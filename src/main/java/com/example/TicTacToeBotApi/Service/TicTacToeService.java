package com.example.TicTacToeBotApi.Service;

import com.example.TicTacToeBotApi.Model.Board;
import com.example.TicTacToeBotApi.Model.Bot;
import org.springframework.stereotype.Service;

@Service
public class TicTacToeService {

    private Board board;
    private Bot bot;

    public TicTacToeService() {
        board = new Board();
        bot = new Bot();
    }

    public Board startGame() {
        board.resetBoard();
        return board;
    }

    public Board playHuman(int row, int col) {
        if (board.placeMove(row, col, board.getHumanPlayer()) && !board.isGameOver()) {
            int[] botMove = bot.getNextMove(board);
            if (board.placeMove(botMove[0], botMove[1], board.getBotPlayer())) {
                return board;
            }
        }

        return null;
    }

    public Board playBot() {
        int[] botMove = bot.getNextMove(board);
        if (board.placeMove(botMove[0], botMove[1], board.getBotPlayer())) {
            return board;
        }

        return null;
    }

    public Board reset() {
        board.resetBoard();
        return board;
    }
}
