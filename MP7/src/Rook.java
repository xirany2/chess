public class Rook extends Chess{
    public String name = "Rook";
    public Rook(Player play){
        super(play);
    }
    // If the move is illegal
    public boolean canMove(Chess[][] board, int x1, int y1, int x2, int y2){
        if (!super.canMove(board, x1, y1, x2, y2)){
            return false;
        }
        // Rook can only move along a row or a column
        if ((x1 != x2) && (y1 != y2)){
            return false;
        }
        // Rook cannot leap over other pieces
        if ((x1 == x2) && (y1 != y2)){
            int betweeny;
            if (y1 > y2){
                betweeny = y1 - 1;
                while (betweeny > y2){
                    if (board[x1][betweeny] != null){
                        return false;
                    }
                    betweeny--;
                }
            } else {
                betweeny = y1 + 1;
                while (betweeny < y2){
                    if(board[x1][betweeny] != null){
                        return false;
                    }
                    betweeny++;
                }
            }
        }
        if ((x1 != x2) && (y1 == y2)){
            int betweenx;
            if (x1 > x2){
                betweenx = x1 - 1;
                while (betweenx > x2){
                    if (board[betweenx][y1] != null){
                        return false;
                    }
                    betweenx--;
                }
            } else {
                betweenx = x1 + 1;
                while(betweenx < x2){
                    if (board[betweenx][y1] != null){
                        return false;
                    }
                    betweenx++;
                }
            }
        }
        return true;
    }
}
