package com.codecool.filepartreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader fpr;

    FileWordAnalyzer(FilePartReader fpr) {
        this.fpr = fpr;
    }

    public List getWordsOrderedAlphabetically (String[] words) throws IOException {
        List<String> orderedWords = new ArrayList<>(Arrays.asList(words));

        orderedWords.sort(String.CASE_INSENSITIVE_ORDER);

        return orderedWords;
    }

    public List getWordsContainingSubstring (String subString, String[] words) throws IOException {
        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (word.contains(subString)) filteredWords.add(word);
        }

        return filteredWords;
    }

    public List getStringsWhichPalindromes (String[] words) throws IOException {
        List<String> palindromes = new ArrayList<>();

        for (String word : words) {
            if (isPalindrome(word)) palindromes.add(word);
        }

        return palindromes;
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        if (length < 2) return true;
        return s.charAt(0) == s.charAt(length - 1) && isPalindrome(s.substring(1, length - 1));
    }
}
