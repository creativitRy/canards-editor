// This is a generated file. Not intended for manual editing.
package com.cloudcanards.canardseditor.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.cloudcanards.canardseditor.psi.CanardTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CanardParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == EMOTION_HANDLE) {
      r = emotion_handle(b, 0);
    }
    else if (t == NODE) {
      r = node(b, 0);
    }
    else if (t == SPEAKER) {
      r = speaker(b, 0);
    }
    else if (t == TEXT_BODY) {
      r = text_body(b, 0);
    }
    else if (t == TEXT_NODE) {
      r = text_node(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return canardFile(b, l + 1);
  }

  /* ********************************************************** */
  // item*
  static boolean canardFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canardFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "canardFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EMOTION_LEFT_PAREN EMOTION EMOTION_RIGHT_PAREN
  public static boolean emotion_handle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "emotion_handle")) return false;
    if (!nextTokenIs(b, EMOTION_LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EMOTION_LEFT_PAREN, EMOTION, EMOTION_RIGHT_PAREN);
    exit_section_(b, m, EMOTION_HANDLE, r);
    return r;
  }

  /* ********************************************************** */
  // node|COMMENT|EMPTY
  static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    r = node(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, EMPTY);
    return r;
  }

  /* ********************************************************** */
  // (text_node)
  public static boolean node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE, "<node>");
    r = text_node(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AT NAME [emotion_handle]
  public static boolean speaker(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "speaker")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT, NAME);
    r = r && speaker_2(b, l + 1);
    exit_section_(b, m, SPEAKER, r);
    return r;
  }

  // [emotion_handle]
  private static boolean speaker_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "speaker_2")) return false;
    emotion_handle(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (TEXT|SPECIAL_CHAR)+
  public static boolean text_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_body")) return false;
    if (!nextTokenIs(b, "<text body>", SPECIAL_CHAR, TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_BODY, "<text body>");
    r = text_body_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!text_body_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "text_body", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TEXT|SPECIAL_CHAR
  private static boolean text_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_body_0")) return false;
    boolean r;
    r = consumeToken(b, TEXT);
    if (!r) r = consumeToken(b, SPECIAL_CHAR);
    return r;
  }

  /* ********************************************************** */
  // [speaker] text_body
  public static boolean text_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_node")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_NODE, "<text node>");
    r = text_node_0(b, l + 1);
    r = r && text_body(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [speaker]
  private static boolean text_node_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_node_0")) return false;
    speaker(b, l + 1);
    return true;
  }

}
