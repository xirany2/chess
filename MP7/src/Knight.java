public class Knight extends Chess {
    public String name = "Knight      ";
    public Knight(Player play) {
    super(play);
    super.name = this.name;
    }
    public boolean canMove(Chess[][] board, int x1, int y1, int x2, int y2) {
        if (!super.canMove(board, x1, x2, y1, y2)){
            return false;
        }
        if (Math.abs(x2 - x1) == 2 && Math.abs(y2 - y1) == 1) {
        return true;
        }
        if (Math.abs(x2 - x1) == 1 && Math.abs(y2 - y1) == 2) {
        return true;
        }
        return false;
    }
}
