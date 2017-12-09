public abstract class Chess {
    public Player owner;
    public boolean moved = false;
    public Chess (Player a) {
        this.owner = a;
    }
    public boolean canMove(Chess[][] board, int x1, int y1, int x2, int y2) {
        if (board[x2][y2] == null) {
            return true;
        }
        if (board[x1][y1].owner == board[x2][y2].owner) {
            System.out.println("The destination chess is yours!");
            return false;
        }
        return true;
    }
    public static void move(Chess[][] board, int x1, int y1, int x2, int y2) {
        board[x2][y2] = board[x1][y1];
        board[x1][y1] = null;
        board[x2][y2].moved = true;
    }
}
