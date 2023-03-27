package com.example.TicTacToeBotApi.Model;

public class Board {
    private char[][] cells = new char[3][3];

    public Board() {
        // Initialize the board with empty cells
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col] = '-';
            }
        }
    }

    public void update(int row, int col, char player) {
        cells[row][col] = player;
    }

    public boolean isWin(char player) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (cells[row][0] == player && cells[row][1] == player && cells[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (cells[0][col] == player && cells[1][col] == player && cells[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (cells[0][0] == player && cells[1][1] == player && cells[2][2] == player) {
            return true;
        }
        if (cells[0][2] == player && cells[1][1] == player && cells[2][0] == player) {
            return true;
        }

        return false;
    }

    public boolean isDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (cells[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getCells() {
        return cells;
    }
}
