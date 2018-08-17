package com.cloudcanards.canardseditor.syntaxhighlight;

import com.cloudcanards.canardseditor.CanardIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * CanardColorSettingsPage
 *
 * @author ctRy
 */
public class CanardColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Comment", CanardSyntaxHighlighter.COMMENT[0]),

            new AttributesDescriptor("Starting At", CanardSyntaxHighlighter.AT[0]),
            new AttributesDescriptor("Speaker Name", CanardSyntaxHighlighter.NAME[0]),
            new AttributesDescriptor("Speaker Emotion", CanardSyntaxHighlighter.EMOTION[0]),

            new AttributesDescriptor("Text", CanardSyntaxHighlighter.TEXT[0]),
            new AttributesDescriptor("Text Escaped Characters", CanardSyntaxHighlighter.TEXT_ESCAPED[0]),
            new AttributesDescriptor("Text Invalid Escaped Characters", CanardSyntaxHighlighter.TEXT_ESCAPED_INVALID[0]),

            new AttributesDescriptor("Text Variable", CanardSyntaxHighlighter.TEXT_VARIABLE[0]),
            new AttributesDescriptor("Text Variable At", CanardSyntaxHighlighter.TEXT_VARIABLE_SEPARATOR[0]),
            new AttributesDescriptor("Number", CanardSyntaxHighlighter.NUMBER[0]),
            new AttributesDescriptor("Branch Else", CanardSyntaxHighlighter.TEXT_VARIABLE_ELSE[0]),
            new AttributesDescriptor("Brackets", CanardSyntaxHighlighter.BRACKET[0]),
            new AttributesDescriptor("Parentheses", CanardSyntaxHighlighter.PARENTHESES[0]),

            new AttributesDescriptor("Label", CanardSyntaxHighlighter.LABEL[0]),
            new AttributesDescriptor("Keyword", CanardSyntaxHighlighter.KEYWORD[0]),
            new AttributesDescriptor("Goto", CanardSyntaxHighlighter.GOTO[0]),
            new AttributesDescriptor("Exit", CanardSyntaxHighlighter.EXIT[0]),

            new AttributesDescriptor("Choices", CanardSyntaxHighlighter.CHOICE[0])
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return CanardIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new CanardSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "@Yanna here is text\n" +
                "Here is more with \\@ escaped text (even invalid \\ones too)\\\n" +
                "And line breaks.\n" +
                "# here are comments\n" +
                "@Yanna(angry) here is text with emotion\n" +
                "@Yanna(sad) here are @variables@\n" +
                "Even more @variables 2@two@[3,6]@more@(1,7)@great@e@rest@\n" +
                "\n" +
                "@wow\n" +
                "\n" +
                "@goto wow\n" +
                "@goto unknownLabel\n" +
                "\n" +
                "@choice\n" +
                "Option 1\n" +
                "\tWow\n" +
                "Option 2\n" +
                "\tMore\n" +
                "Option 3\n" +
                "\toops\n" +
                "\t@exit\n" +
                "@end\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Canard";
    }
}
