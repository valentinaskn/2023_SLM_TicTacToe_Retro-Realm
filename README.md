# Tic-Tac-Toe Game

## Description
This is a console-based implementation of Tic-Tac-Toe. It is designed for two players and has a simple text interface for playing the game on a 3x3 grid. The players take turns to place their markers.

## Features
- Command-line interface for gameplay
- Player input validation
- Option to play multiple games in succession

## How to Play
- The game board consists of a 3x3 grid.
- Player 1 uses the 'X' marker, while Player 2 uses the 'O' marker.
- Players alternate turns to place a marker in an empty grid cell.
- The first player to align three of their markers horizontally, vertically, or diagonally wins the game.
- If all grid cells are filled without a winning alignment, the game is declared a draw.

## Project Structure
- `Player.java`: Defines the `Player` class with a marker attribute and methods related to the player.
- `Board.java`: Defines the `Board` class that maintains the game board and checks the game status.
- `TicTacToe.java`: Contains the main method and orchestrates the game play, including the game loop and player turns.

## Testing
Unit tests for the `Player`, `Board` and `TicTacToe` classes are included to validate the game's logic. 



