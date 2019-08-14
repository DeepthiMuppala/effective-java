class Main {
  public void playSudoku(Sudoku sudoku) {
    int[][] board = new int[9][9];
    int randomRow = (int) Math.ceil(Math.random() * 9) - 1;
    int randomCol = (int) Math.ceil(Math.random() * 9) - 1;
    int randomVal = (int) Math.ceil(Math.random() * 9) - 1;
    board[randomRow][randomCol] = randomVal;
    sudoku.sudokuSolver(board);
  }

  public static void main(String[] args) {
    Sudoku sudoku = new Sudoku();
    Main m = new Main();
    m.playSudoku(sudoku); 
  }
}