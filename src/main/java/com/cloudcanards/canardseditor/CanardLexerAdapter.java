package com.cloudcanards.canardseditor;

import com.intellij.lexer.FlexAdapter;

/**
 * CanardLexerAdapter
 *
 * @author ctRy
 */
public class CanardLexerAdapter extends FlexAdapter {
    public CanardLexerAdapter() {
        super(new CanardLexer(null));
    }
}
