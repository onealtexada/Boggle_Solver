package com.rstudio.boggle.service.impl;

import com.rstudio.boggle.service.Dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class BoggleDictionary implements Dictionary {

    private static NavigableSet<String> dictionary;

    static {
        dictionary = new TreeSet<>();
        try {
            InputStream in = BoggleDictionary.class
                .getResourceAsStream("/static/words_alpha.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Error while reading dictionary");
        }
    }

    @Override
    public boolean validWord(String word, Set<String> validWords) {
        if (word.length() > 2 && dictionary.contains(word) && !validWords.contains(word)) {
            validWords.add(word);
            return true;
        }

        return false;
    }

    @Override
    public boolean validPrefix(String prefix) {
        return !dictionary.subSet(prefix, prefix + Character.MAX_VALUE)
            .isEmpty();
    }
}
