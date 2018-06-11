package com.rstudio.boggle.service.impl;

import static org.junit.Assert.assertEquals;

import com.rstudio.boggle.service.BoggleScorer;

import org.junit.Test;

public class BoggleScorer4x4BoardTest {

    private BoggleScorer scoreCard = new BoggleScorer4x4Board();

    @Test
    public void testScore() {
        String word = "ace";
        Integer score = scoreCard.score(word);
        assertEquals(score, new Integer(1));
    }
}
