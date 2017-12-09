public class Queen extends Chess{
    public String name = "Queen";
    public Queen(Player play){
        super(play);
    }
    public boolean canMove(Chess[][] board, int x1, int y1, int x2, int y2){
        if (!super.canMove(board, x1, y1, x2, y2)){
            return false;
        }
        // Queen can move on rows, columns, and diagnols
        if ((Math.abs(x2 - x1) != Math.abs(y2 - y1))
            &&((x1 != x2) && (y1 != y2))){
                return false;
        }
        int betweenx, betweeny;
        // Queen cannot leap over other pieces on rows or columns
        if ((x1 == x2) && (y1 != y2)){
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
        // Queen cannot leap over pieces on diagnols
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
