package com.cloudcanards.canardseditor.psi;

import com.cloudcanards.canardseditor.CanardLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * CanardTokenType
 *
 * @author ctRy
 */
public class CanardTokenType extends IElementType {
    public CanardTokenType(@NotNull String debugName) {
        super(debugName, CanardLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "CanardTokenType." + super.toString();
    }
}
