package com.cloudcanards.canardseditor;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * CanardFileTypeFactory
 *
 * @author ctRy
 */
public class CanardFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(CanardFileType.INSTANCE);
    }
}
