// This is a generated file. Not intended for manual editing.
package com.cloudcanards.canardseditor.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.cloudcanards.canardseditor.psi.impl.*;

public interface CanardTypes {

  IElementType EMOTION_HANDLE = new CanardElementType("EMOTION_HANDLE");
  IElementType NODE = new CanardElementType("NODE");
  IElementType SPEAKER = new CanardElementType("SPEAKER");
  IElementType TEXT_BODY = new CanardElementType("TEXT_BODY");
  IElementType TEXT_NODE = new CanardElementType("TEXT_NODE");

  IElementType AT = new CanardTokenType("AT");
  IElementType COMMENT = new CanardTokenType("COMMENT");
  IElementType EMOTION = new CanardTokenType("EMOTION");
  IElementType EMPTY = new CanardTokenType("EMPTY");
  IElementType LEFT_PAREN = new CanardTokenType("LEFT_PAREN");
  IElementType NAME = new CanardTokenType("NAME");
  IElementType RIGHT_PAREN = new CanardTokenType("RIGHT_PAREN");
  IElementType SPECIAL_CHAR = new CanardTokenType("SPECIAL_CHAR");
  IElementType TEXT = new CanardTokenType("TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == EMOTION_HANDLE) {
        return new CanardEmotionHandleImpl(node);
      }
      else if (type == NODE) {
        return new CanardNodeImpl(node);
      }
      else if (type == SPEAKER) {
        return new CanardSpeakerImpl(node);
      }
      else if (type == TEXT_BODY) {
        return new CanardTextBodyImpl(node);
      }
      else if (type == TEXT_NODE) {
        return new CanardTextNodeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
