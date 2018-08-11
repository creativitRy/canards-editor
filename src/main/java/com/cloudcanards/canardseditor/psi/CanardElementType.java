package com.cloudcanards.canardseditor.psi;

import com.cloudcanards.canardseditor.CanardLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * CanardElementType
 *
 * @author ctRy
 */
public class CanardElementType extends IElementType {
    public CanardElementType(@NotNull String debugName) {
        super(debugName, CanardLanguage.INSTANCE);
    }
}
