package com.example.TicTacToeBotApi.Controller;

import com.example.TicTacToeBotApi.Model.Board;
import com.example.TicTacToeBotApi.Model.Bot;
import com.example.TicTacToeBotApi.Model.GameResult;
import com.example.TicTacToeBotApi.Model.MoveRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    private Board board;
    private Bot bot;

    public GameController() {
        board = new Board();
        bot = new Bot();
    }

    @GetMapping("/board")
    public char[][] getBoard() {
        return board.getCells();
    }

    @PostMapping("/move")
    public GameResult makeMove(@RequestBody MoveRequest request) {
        int row = request.getRow();
        int col = request.getCol();
        char player = request.getPlayer();
        board.update(row, col, player);
        char[][] gameBoard = board.getCells();
        if (board.isWin(player)) {
            return new GameResult(gameBoard, player + " wins!");
        } else if (board.isDraw()) {
            return new GameResult(gameBoard, "Draw");
        } else {
            int botMove = bot.getMove(board);
            int botRow = botMove / 3;
            int botCol = botMove % 3;
            board.update(botRow, botCol, 'O');
            gameBoard = board.getCells();
            if (board.isWin('O')) {
                return new GameResult(gameBoard, "Bot wins!");
            } else if (board.isDraw()) {
                return new GameResult(gameBoard, "Draw");
            } else {
                return new GameResult(gameBoard, "");
            }
        }
    }
}