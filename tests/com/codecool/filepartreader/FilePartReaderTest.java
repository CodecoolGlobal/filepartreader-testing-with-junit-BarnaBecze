package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testIsIllegalArgumentExceptionThrown() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            fpr.setup(fpr.filePath, fpr.fromLine, fpr.toLine);
        });
    }

    @Test
    public void testIsIOExceptionThrown() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IOException.class, fpr::read);
        assertThrows(IOException.class, fpr::readLines);
    }
}