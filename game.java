public class game{
    chess[][] board = new chess[9][9];
    boolean started = false;
    player winner = null;
    player player1 = null;
    player player2 = null;
    boolean whoseTurn = false; // false means player1's turn, true otherwise
    public game(player player1, player player2) { 
    this.player1 = player1;
    this.player2 = player2;
    
    }
    public boolean move(int x1, int y1, int x2, int y2) { 
    if (winner != null) {
        return false;
    }
    if (!whoseTurn) {
       if(chess[x1][y1].owner != player1) {
         return false;  
       } 
    } else {
        if (chess[x1][y1].owner != player2) {
            return false;
        }
    }
    if (!chess[x1][y1].canMove(int x2, int y2)) {
        return false;
      }
    whoseTurn = !whoseTurn;
    chess[x1][y1].move(x2, y2);
    if (chess[x2][y2] instanceof king) {
        winner = (whoseTurn)? player2:player1;
    }
    chess[x1][y1] = null;
    }
}