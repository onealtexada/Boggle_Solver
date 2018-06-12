package com.rstudio.boggle.service;

import com.rstudio.boggle.service.impl.BoggleDictionary;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.inject.Inject;

import java.util.HashSet;
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
        Set<String> usedTile;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                usedTile = new HashSet<>();
                solve(board, i, j, i, j,
                    String.valueOf(board[i][j]).equalsIgnoreCase("q") ? "qu"
                        : String.valueOf(board[i][j]).toLowerCase(),
                    validWords, usedTile);
            }
        }

        return validWords;
    }

    private void solve(char[][] board, int initialX, int initialY, int i, int j, String prefix,
        Set<String> validWords, Set<String> usedTile) {
        Assert.notNull(board, "Boggle Board is null");
        Assert.notNull(validWords, "ValidWords list is null");

        usedTile.add(i + "," + j);
        int startingXValue = Math.max(0, i - 1);
        int startingYValue = Math.max(0, j - 1);
        int adjacentXValue = Math.min(board.length, i + 2);
        int adjacentYValue = Math.min(board.length, j + 2);

        for (int x = startingXValue; x < adjacentXValue; x++) {
            for (int y = startingYValue; y < adjacentYValue; y++) {
                if (usedTile.contains(x + "," + y)) {
                    continue;
                }

                String word =
                    prefix + (String.valueOf(board[x][y]).equalsIgnoreCase("q")
                        ? "qu" : String.valueOf(board[x][y]).toLowerCase());

                if (word.equals("with")) {
                    System.out.println("Got Here");
                }

                if (dictionary.validWord(word, validWords)) {
                    usedTile = new HashSet<>();
                    solve(board, initialX, initialY, initialX, initialY, word, validWords, usedTile);
                }
                else if (dictionary.validPrefix(word)) {
                    dictionary.validWord(word, validWords);
                    usedTile.add(x + "," + y);
                    solve(board, initialX, initialY, x, y, word, validWords, usedTile);
                } else {
                    usedTile.remove(x + "," + y);
                }
            }
        }
    }
}
