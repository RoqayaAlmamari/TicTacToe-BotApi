package com.example.TicTacToeBotApi.Model;

public class GameResult {
    private char[][] board;
    private String message;

    public GameResult() {
    }

    public GameResult(char[][] board, String message) {
        this.board = board;
        this.message = message;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
