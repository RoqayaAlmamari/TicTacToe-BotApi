package com.example.TicTacToeBotApi.Model;

import com.example.TicTacToeBotApi.Model.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot {
    private Random random = new Random();

    public int getMove(Board board) {
        // Get a list of available cells
        List<Integer> availableCells = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getCells()[row][col] == '-') {
                    availableCells.add(row * 3 + col);
                }
            }
        }

        // Choose a random available cell
        int randomIndex = random.nextInt(availableCells.size());
        return availableCells.get(randomIndex);
    }
}
