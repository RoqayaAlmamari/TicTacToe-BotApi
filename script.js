const apiEndpoint = "http://localhost:8080/move";
let player = "X";
let gameOver = false;

// Update the game board with a move
function updateBoard(position) {
  // Make a POST request to the API to get the computer's move
  const data = { board: board, position: position, player: player };
  fetch(apiEndpoint, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  })
    .then((response) => response.json())
    .then((data) => {
      // Update the board with the computer's move
      board = data.board;
      updateBoardUI();

      // Check if the game is over
      if (data.result !== null) {
        gameOver = true;
        if (data.result === "DRAW") {
          displayMessage("Game over. It's a draw!");
        } else {
          displayMessage(`Game over. ${data.result} wins!`);
        }
      } else {
        // It's the player's turn again
        player = "X";
        displayMessage("It's your turn!");
      }
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}

// Display a message to the player
function displayMessage(message) {
  const messageElement = document.getElementById("message");
  if (messageElement !== null) {
    messageElement.innerText = message;
  }
}

// Update the UI to display the current game board
function updateBoardUI() {
  const boardElement = document.getElementById("board");
  if (boardElement !== null) {
    boardElement.innerHTML = "";
    for (let i = 0; i < board.length; i++) {
      for (let j = 0; j < board[i].length; j++) {
        const square = document.createElement("div");
        square.classList.add("square");
        square.dataset.row = i;
        square.dataset.col = j;
        square.addEventListener("click", handleSquareClick);
        if (board[i][j] === "X") {
          square.classList.add("x");
        } else if (board[i][j] === "O") {
          square.classList.add("o");
        }
        boardElement.appendChild(square);
      }
    }
  }
}

// Handle a click on a game board square
function handleSquareClick(event) {
  if (gameOver) {
    return;
  }
  const row = event.target.dataset.row;
  const col = event.target.dataset.col;
  if (board[row][col] === "") {
    board[row][col] = player;
    updateBoardUI();
    player = "O";
    displayMessage("Wait for bot to move!");
    updateBoard({ row: row, col: col });
  }
}

// Initialize the game board and display the UI
let board = [["", "", ""], ["", "", ""], ["", "", ""]];
updateBoardUI();
displayMessage("It's your turn!");
