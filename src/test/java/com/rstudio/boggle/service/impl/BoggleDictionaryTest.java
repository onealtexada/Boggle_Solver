package com.rstudio.boggle.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.rstudio.boggle.service.Dictionary;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class BoggleDictionaryTest {

    private final Dictionary dictionary = new BoggleDictionary();

    @Test
    public void testValidWord() {
        String word = "ace";
        Set<String> validWords = new HashSet<>();
        boolean validWord = dictionary.validWord(word, validWords);
        assertTrue(validWord);
        assertEquals(new Integer(validWords.size()), new Integer(1));
    }

    @Test
    public void testInValidWord() {
        String word = "ac";
        Set<String> validWords = new HashSet<>();
        boolean validWord = dictionary.validWord(word, validWords);
        assertFalse(validWord);
        assertTrue(validWords.isEmpty());
    }

    @Test
    public void testValidPrefix() {
        String prefix = "ace";
        boolean validPrefix = dictionary.validPrefix(prefix);
        assertTrue(validPrefix);
    }

    @Test
    public void testInValidPrefix() {
        String prefix = "aaaaaa";
        boolean validPrefix = dictionary.validPrefix(prefix);
        assertFalse(validPrefix);
    }
}
