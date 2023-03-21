package com.example.TicTacToeBotApi.Model;

import java.util.Random;
import java.util.List;
public class Bot {
    private Random random;

    public Bot() {
        random = new Random();
    }

    public int[] getNextMove(Board board) {
        List<int[]> availableCells = board.getAvailableCells();

        int[] move = minimax(board, board.getBotPlayer(), 0);

        if (move[0] == -1 && move[1] == -1) {
            move = availableCells.get(random.nextInt(availableCells.size()));
        }

        return move;
    }

    private int[] minimax(Board board, char player, int depth) {
        List<int[]> availableCells = board.getAvailableCells();


        int[] bestMove = new int[3];
        int bestScore = (player == board.getBotPlayer()) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        return bestMove;
    }
}