public class King extends Chess {
    public String name = "King        ";
    public boolean beingAttacked = false;
    public int x1;
    public int x2;
    public King(Player a) {
    super(a);
    super.name = this.name;
    }
    public boolean canMove(Chess[][] board, int x1, int y1, int x2, int y2) {
        if (!super.canMove(board, x1, x2, y1, y2)){
            return false;
        }
        /*if (!moved 
        && board[x2][y2] != null
        && board[x2][y2] instanceOf Rook
        && board[]) {
            //杩欒竟鏄笉鏄繕娌″啓瀹�
            board[x2][y2] = 
            return true;
        }*/
        return (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1);
    }
}
