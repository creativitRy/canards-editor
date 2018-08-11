package com.cloudcanards.canardseditor;

import com.intellij.lang.Language;

public class CanardLanguage extends Language {
    public static final CanardLanguage INSTANCE = new CanardLanguage();

    private CanardLanguage() {
        super("Canard");
    }
}
