// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.codeInsight.intention.impl.preview

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.intention.preview.IntentionPreviewInfo
import com.intellij.ide.plugins.MultiPanel
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.project.Project
import com.intellij.ui.PopupBorder
import com.intellij.ui.components.JBLoadingPanel
import com.intellij.util.ui.JBEmptyBorder
import com.intellij.util.ui.JBHtmlEditorKit
import com.intellij.util.ui.JBUI
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JComponent
import javax.swing.JEditorPane
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.text.Element
import javax.swing.text.View
import javax.swing.text.ViewFactory
import javax.swing.text.html.HTML

internal class IntentionPreviewComponent(project: Project) : JBLoadingPanel(BorderLayout(),
                                                                            { panel -> IntentionPreviewLoadingDecorator(panel, project) }) {
  private var NO_PREVIEW_LABEL = JLabel(CodeInsightBundle.message("intention.preview.no.available.text") + "     ").also { setupLabel(it) }
  private var LOADING_LABEL = JLabel(CodeInsightBundle.message("intention.preview.loading.preview") + "     ").also { setupLabel(it) }

  var editors: List<EditorEx> = emptyList()
  var html: IntentionPreviewInfo.Html? = null

  val multiPanel: MultiPanel = object : MultiPanel() {
    override fun create(key: Int): JComponent {
      return when (key) {
        NO_PREVIEW -> NO_PREVIEW_LABEL
        LOADING_PREVIEW -> LOADING_LABEL
        else -> {
          val htmlInfo = html
          if (htmlInfo != null) {
            return createHtmlPanel(htmlInfo)
          }
          if (editors.isEmpty()) return NO_PREVIEW_LABEL

          IntentionPreviewEditorsPanel(mutableListOf<EditorEx>().apply { addAll<EditorEx>(editors) })
        }
      }
    }

    private fun createHtmlPanel(htmlInfo: IntentionPreviewInfo.Html): JPanel {
      val editor = object : JEditorPane() {
        var prefHeight: Int? = null

        override fun getPreferredSize(): Dimension {
          if (prefHeight == null) {
            val pos = modelToView2D(document.endPosition.offset.coerceAtLeast(1) - 1)
            if (pos != null) {
              prefHeight = pos.maxY.toInt() + 5
            }
          }
          return Dimension(IntentionPreviewPopupUpdateProcessor.MIN_WIDTH, prefHeight ?: Integer.MAX_VALUE)
        }
      }

      val factory = object : JBHtmlEditorKit.JBHtmlFactory() {
        override fun create(elem: Element): View {
          if (elem.name == "img") {
            val src = elem.attributes.getAttribute(HTML.Attribute.SRC) as? String
            val prefix = "local://"
            if (src != null && src.startsWith(prefix)) {
              val icon = htmlInfo.icon(src.substring(prefix.length))
              if (icon != null) {
                return IconView(elem, icon)
              }
            }
          }
          return super.create(elem)
        }
      }
      editor.editorKit = object : JBHtmlEditorKit() {
        override fun getViewFactory(): ViewFactory {
          return factory
        }
      }
      editor.text = htmlInfo.content().toString()
      editor.size = Dimension(IntentionPreviewPopupUpdateProcessor.MIN_WIDTH, Integer.MAX_VALUE)
      val panel = JPanel(BorderLayout())
      panel.background = editor.background
      panel.add(editor, BorderLayout.CENTER)
      panel.border = JBEmptyBorder(5)
      return panel
    }
  }

  init {
    add(multiPanel)
    border = PopupBorder.Factory.create(true, true)
    setLoadingText(CodeInsightBundle.message("intention.preview.loading.preview"))
  }

  companion object {
    const val NO_PREVIEW = -1
    const val LOADING_PREVIEW = -2

    private fun setupLabel(label: JLabel) {
      label.border = JBUI.Borders.empty(3)
      label.background = EditorColorsManager.getInstance().globalScheme.defaultBackground
    }
  }
}