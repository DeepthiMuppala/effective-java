import java.util.*;

class TicTacToe {

   public static void main(String[] args) {
    Board board = null;
    int size = 0;
    int count = 0;
    boolean isCompleted = false;

    Scanner scanner = new Scanner(System.in);
    do {
        System.out.print("Please initialize the size greater than 2 ");
        size = scanner.nextInt();
        if (size > 2) {
          board = new Board(size);
        }
      } while (board == null);
    do{
        count++;
        char s = count%2 == 0 ? Board.Player.X.asChar() : Board.Player.Y.asChar();
        System.out.println();
        System.out.print("Enter row to insert for Player " + s + " ");
        int row = scanner.nextInt();
        System.out.println();
        System.out.print("Enter column to insert for Player " + s + " ");
        int col = scanner.nextInt();
        boolean isPlaced = board.placeMove(s, row, col);
        board.printBoard();
        if(!isPlaced) {
            System.out.println("Unable to place the move, Please enter row and column values less than or equal to " + size);
            count--;
            continue;
        }
        isCompleted = board.isGameCompleted();
        if(isCompleted) System.out.println("Player " + s + " Won!!");
      } while(!isCompleted);
   }
}

