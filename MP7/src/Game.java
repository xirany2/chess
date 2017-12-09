public class Game {
    public Chess[][] board = new Chess[9][9];
    boolean started = false;
    Player winner = null;
    Player player1 = null;
    Player player2 = null;
    boolean player2Turn = false; // false means player1's turn, true otherwise
    public Game(Player player1, Player player2) { 
    this.player1 = player1;
    this.player2 = player2;
    //contruct a board
    }
    
    public boolean move(int x1, int y1, int x2, int y2) { 
        if (!canMove(x1, y1, x2, y2)) {
            return false;
        }
        board[x1][y1].move(this.board, x1, y1, x2, y2);
        player2Turn = !player2Turn;
        if (board[x2][y2] instanceof King) {
            winner = (player2Turn)? player2:player1;
        }
        return true;
        }

    public boolean canMove(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            System.out.println("Do not move on the same location!");
            return false;
        }
        if (winner != null) {
            System.out.println("This game has been finished!");
            return false;
        }
        if (board == null) {
            System.out.println("This game has not yet started!");
            return false;
        }
        if (x1 > 8 || x1 < 1 ||
            x2 > 8 || x2 < 1 ||
            y1 > 8 || y1 < 1 ||
            y2 > 8 || y2 < 1) {
             System.out.println("The target is out of board!");
             return false;
         }
        if (board[x1][y1] == null) {
            System.out.println("There is no chess on targeted location!");
            return false;
        }
        if (!player2Turn) {
           if(board[x1][y1].owner != player1) {
            System.out.println("This is not your chess!");
            return false;
           }
        } else {
            if (board[x1][y1].owner != player2) {
            System.out.println("This is not your chess!");
            return false;
            }
        }
        if (!board[x1][y1].canMove(board, x1, y1, x2, y2)) {
            System.out.println("The move is illegal!");
            return false;
          }
        return true;
        }
    public boolean checkWhetherAttacked(int x1, int y1) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (board[i][j] == null) {
                    continue;
                }
                if (player2Turn ^ board[i][j].owner == player1) {
                    continue;
                }
                if (canMove(i, j, x1, y1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
