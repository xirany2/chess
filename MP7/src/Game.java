public class Game {
    public Chess[][] board1 = new Chess[9][9];
    public Chess[][] board2 = new Chess[9][9];
    boolean started = false;
    Player winner = null;
    Player player1 = null;
    Player player2 = null;
    boolean player2Turn = false; // false means player1's turn, true otherwise
    
    public Game(Player player1, Player player2) { 
    this.player1 = player1;
    this.player2 = player2;
    board1[1][1] = new Rook(player1);
    board1[2][1] = new Knight(player1);
    board1[3][1] = new Bishop(player1);
    board1[4][1] = new King(player1);
    board1[5][1] = new Queen(player1);
    board1[7][1] = new Knight(player1);
    board1[6][1] = new Bishop(player1);
    board1[8][1] = new Rook(player1); 
    for (int i = 1; i <= 8; i++) board1[i][2] = new Pawn(player1);
    board1[1][8] = new Rook(player2);
    board1[2][8] = new Knight(player2);
    board1[3][8] = new Bishop(player2);
    board1[4][8] = new King(player2);
    board1[5][8] = new Queen(player2);
    board1[7][8] = new Knight(player2);
    board1[6][8] = new Bishop(player2);
    board1[8][8] = new Rook(player2); 
    for (int i = 1; i <= 8; i++) board1[i][7] = new Pawn(player2);
    copy(board1, board2);
    }
    
    public boolean move(int x1, int y1, int x2, int y2) { 
       
       if (player2Turn) { 
    	   if (!canMove(board2, x1, y1, x2, y2)) {
            return false;
            }
           board2[x1][y1].move(board2, x1, y1, x2, y2);
           copy(board2, board1);
           if (board2[x2][y2] instanceof King) {
            winner = (player2Turn)? player2:player1;
           }
       } else {
    	   if (!canMove(board1, x1, y1, x2, y2)) {
               return false;
           }
           board1[x1][y1].move(board1, x1, y1, x2, y2);
           copy(board1, board2);
           if (board1[x2][y2] instanceof King) {
            winner = (player2Turn)? player2:player1;
           }
       }
        player2Turn = !player2Turn;
        return true;
        }
    
     public static void copy(Chess[][] board1, Chess[][] board2) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                board2[i][j] = board1[9 - i][9 - j];
            }
        }
    }
     
    public boolean canMove(Chess[][] board, int x1, int y1, int x2, int y2) {
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
                if (board1[i][j] == null) {
                    continue;
                }
                if (player2Turn ^ board1[i][j].owner == player1) {
                    continue;
                }
                if (canMove(board1, i, j, x1, y1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
