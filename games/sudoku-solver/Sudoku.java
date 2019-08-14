import java.util.*;
class Sudoku {
  public void sudokuSolver(int[][] board) {
    if(board.length == 0) return;
    sudokuSolverHelper(board);
    printBoard(board);
  }

  public void printBoard(int[][] board) {
    for(int i=0; i < board.length; i++) {
      System.out.println();
      for(int j=0; j< board[0].length; j++){
        System.out.print(" " + board[i][j]);
      }
      System.out.println();
    }
  }

  public boolean sudokuSolverHelper(int[][] board){
    int row = board.length;
    int col = board[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if(board[i][j] != 0) continue;
        for(int val = 1; val < 10; val++) {
          if (isValid(i, j, board, val)) {
            board[i][j] = val;
            if(sudokuSolverHelper(board)) {
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

  public boolean isValid(int i, int j, int[][] board, int val) {
    for (int t = 0; t < board[0].length; t++) {
      if (board[i][t] != 0 && board[i][t] == val) {
        return false;
      } else if (board[t][j] != 0 && board[t][j] == val) {
        return false;
      } else if (board[3 * (i / 3) + t / 3][3 * (j / 3) + t % 3] != 0 && board[3 * (i / 3) + t / 3][3 * (j / 3) + t % 3] == val)
        return false;
    }
    return true;
  }
}
