// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.codeInsight;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.test.TestRoot;
import org.junit.runner.RunWith;

/**
 * This class is generated by {@link org.jetbrains.kotlin.testGenerator.generator.TestGenerator}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("idea/tests")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("testData/codeInsight/expressionType")
public class ExpressionTypeTestGenerated extends AbstractExpressionTypeTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("AnonymousObject.kt")
    public void testAnonymousObject() throws Exception {
        runTest("testData/codeInsight/expressionType/AnonymousObject.kt");
    }

    @TestMetadata("ArgumentName.kt")
    public void testArgumentName() throws Exception {
        runTest("testData/codeInsight/expressionType/ArgumentName.kt");
    }

    @TestMetadata("BlockBodyFunction.kt")
    public void testBlockBodyFunction() throws Exception {
        runTest("testData/codeInsight/expressionType/BlockBodyFunction.kt");
    }

    @TestMetadata("IfAsExpression.kt")
    public void testIfAsExpression() throws Exception {
        runTest("testData/codeInsight/expressionType/IfAsExpression.kt");
    }

    @TestMetadata("IfAsExpressionInsideBlock.kt")
    public void testIfAsExpressionInsideBlock() throws Exception {
        runTest("testData/codeInsight/expressionType/IfAsExpressionInsideBlock.kt");
    }

    @TestMetadata("IntersectionTypeWithStarProjection.kt")
    public void testIntersectionTypeWithStarProjection() throws Exception {
        runTest("testData/codeInsight/expressionType/IntersectionTypeWithStarProjection.kt");
    }

    @TestMetadata("Kt11601.kt")
    public void testKt11601() throws Exception {
        runTest("testData/codeInsight/expressionType/Kt11601.kt");
    }

    @TestMetadata("Lambda.kt")
    public void testLambda() throws Exception {
        runTest("testData/codeInsight/expressionType/Lambda.kt");
    }

    @TestMetadata("MethodName.kt")
    public void testMethodName() throws Exception {
        runTest("testData/codeInsight/expressionType/MethodName.kt");
    }

    @TestMetadata("MethodReference.kt")
    public void testMethodReference() throws Exception {
        runTest("testData/codeInsight/expressionType/MethodReference.kt");
    }

    @TestMetadata("MultiDeclaration.kt")
    public void testMultiDeclaration() throws Exception {
        runTest("testData/codeInsight/expressionType/MultiDeclaration.kt");
    }

    @TestMetadata("MultiDeclarationInLambda.kt")
    public void testMultiDeclarationInLambda() throws Exception {
        runTest("testData/codeInsight/expressionType/MultiDeclarationInLambda.kt");
    }

    @TestMetadata("MultiDeclarationInLoop.kt")
    public void testMultiDeclarationInLoop() throws Exception {
        runTest("testData/codeInsight/expressionType/MultiDeclarationInLoop.kt");
    }

    @TestMetadata("PropertyAccessor.kt")
    public void testPropertyAccessor() throws Exception {
        runTest("testData/codeInsight/expressionType/PropertyAccessor.kt");
    }

    @TestMetadata("SmartCast.kt")
    public void testSmartCast() throws Exception {
        runTest("testData/codeInsight/expressionType/SmartCast.kt");
    }

    @TestMetadata("SoftSmartCast.kt")
    public void testSoftSmartCast() throws Exception {
        runTest("testData/codeInsight/expressionType/SoftSmartCast.kt");
    }

    @TestMetadata("SoftSmartCastMultipleTypes.kt")
    public void testSoftSmartCastMultipleTypes() throws Exception {
        runTest("testData/codeInsight/expressionType/SoftSmartCastMultipleTypes.kt");
    }

    @TestMetadata("ThisInLambda.kt")
    public void testThisInLambda() throws Exception {
        runTest("testData/codeInsight/expressionType/ThisInLambda.kt");
    }

    @TestMetadata("typeOfLambda.kt")
    public void testTypeOfLambda() throws Exception {
        runTest("testData/codeInsight/expressionType/typeOfLambda.kt");
    }

    @TestMetadata("VariableDeclaration.kt")
    public void testVariableDeclaration() throws Exception {
        runTest("testData/codeInsight/expressionType/VariableDeclaration.kt");
    }
}
