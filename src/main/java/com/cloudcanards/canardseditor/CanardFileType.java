package com.cloudcanards.canardseditor;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * CanardFileType
 *
 * @author ctRy
 */
public class CanardFileType extends LanguageFileType {
    public static final CanardFileType INSTANCE = new CanardFileType();

    private CanardFileType() {
        super(CanardLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Canard Dialogue";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "CloudCanards dialogue file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "canard";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return CanardIcons.FILE;
    }
}
