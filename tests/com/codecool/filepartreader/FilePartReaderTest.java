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

    @Test
    public void testIsStringRead() throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("/home/bbarna/OOPJava/filepartreader-testing-with-junit-BarnaBecze/docs/simpleText.txt", 1, 1);
        assertEquals("This is a simple test.", fpr.read());

    }

    @Test
    public void testIsCorrectLinesRead() throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("/home/bbarna/OOPJava/filepartreader-testing-with-junit-BarnaBecze/docs/palindromes.txt", 2, 3);
        String expected = "Red rum, sir, is murder\n" +
                "No lemon, no melon";
        assertEquals(expected, fpr.readLines());
    }
}