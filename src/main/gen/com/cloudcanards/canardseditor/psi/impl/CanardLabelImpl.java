// This is a generated file. Not intended for manual editing.
package com.cloudcanards.canardseditor.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.cloudcanards.canardseditor.psi.CanardTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.cloudcanards.canardseditor.psi.*;

public class CanardLabelImpl extends ASTWrapperPsiElement implements CanardLabel {

  public CanardLabelImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CanardVisitor visitor) {
    visitor.visitLabel(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CanardVisitor) accept((CanardVisitor)visitor);
    else super.accept(visitor);
  }

}
