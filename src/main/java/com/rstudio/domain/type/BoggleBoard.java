package com.rstudio.domain.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoggleBoard {
    @JsonProperty
    private String boardSize;

    @JsonProperty
    private String boardString;

    private char[][] board;

    public BoggleBoard() {
    }

    public BoggleBoard(final String boardSize, final String boardString) {
        this.boardSize = boardSize;
        this.boardString = boardString;
    }

    public char[][] getBoard() {
        int x = 0;
        int max = 0;

        if (boardSize.equals(BoardSize.FiveByFive.webValue())) {
            board = new char[5][5];
            max = 5;
        } else if (boardSize.equals(BoardSize.FiveByFive.webValue())) {
            board = new char[6][6];
            max = 6;
        } else {
            board = new char[4][4];
            max = 4;
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                board[i][j] = boardString.charAt(x);
                x++;
            }
        }

        return board;
    }

    public String getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(String boardSize) {
        this.boardSize = boardSize;
    }

    public String getBoardString() {
        return boardString;
    }

    public void setBoardString(String boardString) {
        this.boardString = boardString;
    }
}
