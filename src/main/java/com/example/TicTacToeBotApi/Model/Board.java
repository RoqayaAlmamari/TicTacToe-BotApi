package com.example.TicTacToeBotApi.Model;
import java.util.ArrayList;
import java.util.List;
public class Board {
    private char[][] board;
    private char humanPlayer = 'X';
    private char botPlayer = 'O';

    public Board() {
        board = new char[3][3];
        resetBoard();
    }

    public void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return hasPlayerWon(humanPlayer) || hasPlayerWon(botPlayer) || getAvailableCells().isEmpty();
    }

    public boolean hasPlayerWon(char player) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public List<int[]> getAvailableCells() {
        List<int[]> availableCells = new ArrayList<>();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    availableCells.add(new int[]{row, col});
                }
            }
        }

        return availableCells;
    }

    public boolean placeMove(int row, int col, char player) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-') {
            return false;
        }

        board[row][col] = player;
        return true;
    }

    public char getHumanPlayer() {
        return humanPlayer;
    }

    public char getBotPlayer() {
        return botPlayer;
    }
}
