package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    public void testIsOrderedAlphabetically() throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("docs/simpleText.txt", 1, 1);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        List<String> expected = new ArrayList<String>() {{
            add("a");
            add("is");
            add("simple");
            add("test");
            add("This");
        }};
        String words = fwa.fpr.readLines();
        System.out.println(words);
        assertEquals(expected, fwa.getWordsOrderedAlphabetically(words.split("\\W")));
    }
}