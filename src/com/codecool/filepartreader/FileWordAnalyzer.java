package com.codecool.filepartreader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader fpr;

    FileWordAnalyzer(FilePartReader fpr) {
        this.fpr = fpr;
    }

    private String[] splitLines() {
        String lines = this.fpr.readLines();

        return lines.split("\\s");
    }

    public List getWordsOrderedAlphabetically (String[] words) {
        List<String> orderedWords = new ArrayList<>(Arrays.asList(words));

        Collections.sort(orderedWords);

        return orderedWords;
    }

    public List getWordsContainingSubstring (String subString, String[] words) {
        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (word.contains(subString)) filteredWords.add(word);
        }

        return filteredWords;
    }

    public List getStringsWhichPalindromes (String[] words) {
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
