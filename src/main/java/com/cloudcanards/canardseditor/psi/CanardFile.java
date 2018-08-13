package com.cloudcanards.canardseditor.psi;

import com.cloudcanards.canardseditor.CanardFileType;
import com.cloudcanards.canardseditor.CanardLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * CanardFile
 *
 * @author ctRy
 */
public class CanardFile extends PsiFileBase {
    public CanardFile(@NotNull FileViewProvider fileViewProvider) {
        super(fileViewProvider, CanardLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return CanardFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Canard File";
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
