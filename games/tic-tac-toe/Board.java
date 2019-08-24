import java.util.*;

class Board {

  public enum Player {
    X('X'),
    O('Y');

    public char asChar() {
      return asChar;
  }

  private final char asChar;

    Player(char asChar) {
        this.asChar = asChar;
    }
  }

  char[][] board;
  boolean isCompleted = false;
  public Board(int n) {
    board = new char[n][n];
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j< board.length; j++){
        board[i][j] = '-';
      }
    }
  }
  public boolean checkRowAndColumValidity(int row, int col) {
    int rowLen = board.length;
    int colLen = board[0].length;
    if(row < 0 || col < 0 || row >= rowLen || col >= colLen){
      return false;
    }
    return true;
  }

  public boolean placeMove(char s, int row, int col) {
    row--;
    col--;
    if(!checkRowAndColumValidity(row, col)){
      return false;
    }
    if(board[row][col] != '-') {
      return false;
    }
    board[row][col] = s;
    isCompleted = isGameMove(s, row, col);
    return true;
  }

  public boolean isGameCompleted() {
    return isCompleted;
  }
  private boolean isGameMove(char s, int row, int col) {
    // check right to left diagonal
    int n = board.length;
    for(int j = 0; j < n && board[j][n-j-1] == s; j++) {
        if(j == n-1) return true;
    }
     // check left to right diagonal
    for(int i = 0; i < n && board[i][i] == s; i++) {
        if(i == n-1) return true;
    }
    // check horizontal
    for(int j = 0; j < n && board[row][j] == s; j++) {
      if(j == n-1) return true;
    }

    // check vertical
    for(int i = 0; i < n && board[i][col] == s; i++) {
      if(i == n-1) return true;
    }
    return false;
  }

  public void printBoard(){
    for(int i = 0; i < board.length; i++){
      System.out.println();
      for(int j = 0; j< board.length; j++){
        System.out.print(" " + board[i][j]);
      }
    }
  }
}