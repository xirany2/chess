public class Bishop extends Chess {
    public String name = "Bishop      ";
    public Bishop(Player play){
        super(play);
        super.name = this.name;
    }
    public boolean canMove(Chess[][] board, int x1, int y1, int x2, int y2){
        if (!super.canMove(board, x1, y1, x2, y2)){
            return false;
        }
        // Bishop can move along the diagonals
        if (Math.abs(x2 - x1) != Math.abs(y2 - y1)){
            return false;
        }
        int betweenx;
        int betweeny;
        // Bishop cannon leap over pieces
        if ((x2 > x1) && (y2 > y1)){
            betweenx = x1 + 1;
            betweeny = y1 + 1;
            while ((betweenx < x2) && (betweeny < y2)){
                if (board[betweenx][betweeny].owner != null){
                    return false;
                }
                betweenx++;
                betweeny++;
            }
        }
        if ((x2 > x1) && (y2 < y1)){
            betweenx = x1 + 1;
            betweeny = y1 - 1;
            while (betweenx < x2 && betweeny > y2){
                if (board[betweenx][betweeny].owner != null){
                    return false;
                }
                betweenx++;
                betweeny--;
            }
        }
        if ((x2 < x1) && (y2 < y1)){
            betweenx = x1 - 1;
            betweeny = y1 - 1;
            while (betweenx > x2 && betweeny > y2){
                if (board[betweenx][betweeny].owner != null){
                    return false;
                }
                betweenx--;
                betweeny--;
            }
        }
        if ((x2 < x1) && (y2 > y1)){
            betweenx = x1 - 1;
            betweeny = y1 + 1;
            while (betweenx < x2 && betweeny > y2){
                if (board[betweenx][betweeny].owner != null){
                    return false;
                }
                betweenx--;
                betweeny++;
            }
        }
        return true;
    }
}
