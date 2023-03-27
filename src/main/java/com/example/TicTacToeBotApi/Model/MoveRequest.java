package com.example.TicTacToeBotApi.Model;

public class MoveRequest {
    private int row;
    private int col;
    private char player;

    public MoveRequest() {
    }

    public MoveRequest(int row, int col, char player) {
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }
}
