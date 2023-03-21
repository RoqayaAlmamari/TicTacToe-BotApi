package com.example.TicTacToeBotApi.Controller;

import com.example.TicTacToeBotApi.Model.Board;
import com.example.TicTacToeBotApi.Model.Move;
import com.example.TicTacToeBotApi.Service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tictactoe")
public class TicTacToeController {

    @Autowired
    private TicTacToeService ticTacToeService;

    @GetMapping("/start-game")
    public ResponseEntity<Board> startGame() {
        Board board = ticTacToeService.startGame();
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PostMapping("/play-human")
    public ResponseEntity<Board> playHuman(@RequestBody Move move) {
        Board board = ticTacToeService.playHuman(move.getRow(), move.getCol());
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping("/play-bot")
    public ResponseEntity<Board> playBot() {
        Board board = ticTacToeService.playBot();
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping("/reset")
    public ResponseEntity<Board> reset() {
        Board board = ticTacToeService.reset();
        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}
