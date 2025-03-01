/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.codeInspection;

import com.intellij.codeInsight.intention.FileModifier;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInsight.intention.preview.IntentionPreviewInfo;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LocalQuickFixAsIntentionAdapter implements IntentionAction {
  private final LocalQuickFix myFix;
  @NotNull private final ProblemDescriptor myProblemDescriptor;

  public LocalQuickFixAsIntentionAdapter(@NotNull LocalQuickFix fix, @NotNull ProblemDescriptor problemDescriptor) {
    myFix = fix;
    myProblemDescriptor = problemDescriptor;
  }

  @NotNull
  @Override
  public String getText() {
    return myFix.getName();
  }

  @NotNull
  @Override
  public String getFamilyName() {
    return myFix.getFamilyName();
  }

  @NotNull
  LocalQuickFix getFix() {
    return myFix;
  }

  @Override
  public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
    return myProblemDescriptor.getStartElement() != null;
  }

  @Override
  public void invoke(@NotNull Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
    myFix.applyFix(project, myProblemDescriptor);
  }

  @Nullable
  @Override
  public PsiElement getElementToMakeWritable(@NotNull PsiFile currentFile) {
    return myFix.getElementToMakeWritable(currentFile);
  }

  @Override
  public boolean startInWriteAction() {
    return myFix.startInWriteAction();
  }

  @Override
  public @NotNull IntentionPreviewInfo generatePreview(@NotNull Project project,
                                                       @NotNull Editor editor,
                                                       @NotNull PsiFile file) {
    return myFix.generatePreview(project, myProblemDescriptor.getDescriptorForPreview(file));
  }
}

