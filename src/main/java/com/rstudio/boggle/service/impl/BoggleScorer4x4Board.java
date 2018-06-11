package com.rstudio.boggle.service.impl;

import com.rstudio.boggle.service.BoggleScorer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BoggleScorer4x4Board implements BoggleScorer {

    private static Map<Integer, Integer> scoreCard;

    static {
        scoreCard = new HashMap<>();
        try {
            InputStream in = BoggleScorer4x4Board.class
                .getResourceAsStream("/static/boggle4x4scorecard.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = br.readLine()) != null) {
                scoreCard.put(Integer.parseInt(line.split(":")[0]),
                    Integer.parseInt(line.split(":")[1]));
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Error while reading dictionary");
        }
    }

    @Override
    public Integer score(String word) {
        return scoreCard.get(word.length());
    }
}
