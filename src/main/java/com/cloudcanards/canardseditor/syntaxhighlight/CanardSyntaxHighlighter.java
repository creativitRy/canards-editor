package com.cloudcanards.canardseditor.syntaxhighlight;

import com.cloudcanards.canardseditor.CanardLexerAdapter;
import com.cloudcanards.canardseditor.psi.CanardTokenType;
import com.cloudcanards.canardseditor.psi.CanardTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * CanardSyntaxHighlighter
 *
 * @author ctRy
 */
public class CanardSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey[] AT = create("CANARD_AT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey[] NAME = create("CANARD_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey[] EMOTION = create("CANARD_EMOTION", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey[] TEXT = create("CANARD_TEXT", HighlighterColors.TEXT);
    public static final TextAttributesKey[] TEXT_ESCAPED = create("CANARD_TEXT_ESCAPED", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);
    public static final TextAttributesKey[] TEXT_ESCAPED_INVALID = create("CANARD_TEXT_ESCAPED_INVALID", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);

    public static final TextAttributesKey[] TEXT_VARIABLE = create("CANARD_TEXT_VARIABLE", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey[] TEXT_VARIABLE_SEPARATOR = create("CANARD_TEXT_VARIABLE_SEPARATOR", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey[] NUMBER = create("CANARD_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey[] BRACKET = create("CANARD_BRACKET", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey[] PARENTHESES = create("CANARD_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey[] TEXT_VARIABLE_ELSE = create("CANARD_TEXT_VARIABLE_ELSE", NUMBER[0]);

    public static final TextAttributesKey[] LABEL = create("CANARD_LABEL", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey[] KEYWORD = create("CANARD_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey[] GOTO = create("CANARD_GOTO", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey[] GOTO_BAD = create("CANARD_GOTO_BAD", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey[] CHOICE = create("CANARD_CHOICE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey[] EXIT = create("CANARD_EXIT", KEYWORD[0]);

    public static final TextAttributesKey[] COMMENT = create("CANARD_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    private static final TextAttributesKey[] BAD = create("CANARD_BAD", HighlighterColors.BAD_CHARACTER);
    private static final TextAttributesKey[] EMPTY = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new CanardLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType == null)
            return EMPTY;
        if (tokenType.equals(CanardTypes.AT))
            return AT;
        if (tokenType.equals(CanardTypes.LABEL_NAME))
            return LABEL;
        if (tokenType.equals(CanardTypes.GOTO))
            return KEYWORD;
        if (tokenType.equals(CanardTypes.NAME))
            return NAME;
        if (tokenType.equals(CanardTypes.EMOTION)
                || tokenType.equals(CanardTypes.EMOTION_LEFT_PAREN) || tokenType.equals(CanardTypes.EMOTION_RIGHT_PAREN))
            return EMOTION;
        if (tokenType.equals(CanardTypes.TEXT))
            return TEXT;
        if (tokenType.equals(CanardTypes.SPECIAL_CHAR))
            return TEXT_ESCAPED;
        if (tokenType.equals(CanardTypes.COMMENT))
            return COMMENT;
        if (tokenType.equals(TokenType.BAD_CHARACTER))
            return BAD;
        return EMPTY;
    }

    @NotNull
    @Contract("_, _ -> new")
    private static TextAttributesKey[] create(String name, TextAttributesKey fallback) {
        return new TextAttributesKey[]{TextAttributesKey.createTextAttributesKey(name, fallback)};
    }
}
