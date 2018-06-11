package com.rstudio.boggle.service;

import com.rstudio.boggle.service.impl.BoggleDictionary;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BoggleSolverService {
    Dictionary dictionary = new BoggleDictionary();

    @Inject
    public BoggleSolverService() {
    }

    public Set<String> solve(char[][] board) {
        if (board == null) {
            throw new NullPointerException("The board must have values");
        }

        Set<String> validWords = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                solve(board, i, j,
                    String.valueOf(board[i][j]).equalsIgnoreCase("q") ? "qu"
                        : String.valueOf(board[i][j]).toLowerCase(),
                    validWords);
            }
        }

        return validWords;
    }

    private void solve(char[][] board, int i, int j, String prefix,
        Set<String> validWords) {
        Assert.notNull(board, "Boggle Board is null");
        Assert.notNull(validWords, "ValidWords list is null");

        List<String> usedTile = new ArrayList<>();
        usedTile.add(i + "," + j);

        for (int x = Math.max(0, i - 1); x < Math.min(board.length,
            i + 2); x++) {
            for (int y = Math.max(0, j - 1); y < Math.min(board.length,
                j + 2); y++) {
                if (usedTile.contains(x + "," + y)) {
                    continue;
                }

                usedTile.add(x + "," + y);
                String word = prefix + board[x][y];

                if (dictionary.validPrefix(word)) {
                    dictionary.validWord(word, validWords);
                    solve(board, x, y, word, validWords);
                }
            }
        }
    }
}
