class Main {
 
  public static void main(String[] args) {
    Sudoku sudoku = new Sudoku();
    int[][] board = sudoku.getSolvedBoard();
    sudoku.printBoard(board);
  }
}
