import java.util.*;
class Sudoku {
  int[][] board = new int[9][9];

  public Sudoku() {
    int randomRow = (int) Math.ceil(Math.random() * 9) - 1;
    int randomCol = (int) Math.ceil(Math.random() * 9) - 1;
    int randomVal = (int) Math.ceil(Math.random() * 9);
    board[randomRow][randomCol] = randomVal;
  }

  public int[][] getSolvedBoard() {
    sudokuSolverHelper();
    return board;
  }

  public void printBoard(int[][] solvedBoard) {
    for(int i=0; i < solvedBoard.length; i++) {
      System.out.println();
      for(int j=0; j< solvedBoard[0].length; j++){
        System.out.print(" " + solvedBoard[i][j]);
      }
      System.out.println();
    }
  }

  public boolean sudokuSolverHelper(){
    int row = board.length;
    int col = board[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if(board[i][j] != 0) continue;
        for(int val = 1; val < 10; val++) {
          if (isValid(i, j, val)) {
            board[i][j] = val;
            if(sudokuSolverHelper()) {
              return true;
            }
            else {
              board[i][j] = 0;
            }
          }
        }
        return false;
      }
    }
    return true;
  }

  public boolean isValid(int i, int j, int val) {
    for (int t = 0; t < board[0].length; t++) {
      if (board[i][t] != 0 && board[i][t] == val) {
        return false;
      } else if (board[t][j] != 0 && board[t][j] == val) {
        return false;
      } else if (board[3 * (i / 3) + t / 3][3 * (j / 3) + t % 3] != 0 && 
                  board[3 * (i / 3) + t / 3][3 * (j / 3) + t % 3] == val)
        return false;
    }
    return true;
  }
}
