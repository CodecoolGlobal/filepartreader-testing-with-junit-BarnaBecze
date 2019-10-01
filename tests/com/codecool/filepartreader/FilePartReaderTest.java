package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testIsIllegalArgumentExceptionThrown() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            fpr.setup(fpr.filePath, fpr.fromLine, fpr.toLine);
        });
    }
}