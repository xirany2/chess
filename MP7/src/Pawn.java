public class Pawn extends Chess{ 
    public String name = "Pawn";
    public Pawn(Player play){
        super(play);
    }
    public boolean canMove(Chess[][] board, int x1, int y1, int x2, int y2) {
        boolean flag = false;
        if (!super.canMove(board, x1, x2, y1, y2)){
            return false;
        }
        if (y2 - y1 == 1
        && x2 == x1
        && Game.board[x2][y2] == null) {
        flag = true;
        }
        if (y1 == 2
        && y2 == 4
        && x1 == x2
        board[x1][3] == null) {
        flag = true;
        }
        if (y2 - y1 == 1
        && x2 - x1 == 1
        && x2 - x1 == -1
        && Game.board[x2][y2] != null) {
        flag = true;
        }
        return flag;
        }
    public void elevate(int x, int y, Player owner) {
        System.out.println("Please select which one to elevate");
        System.out.println("1: Queen; 2: Rook; 3: Bishop; 4: Knight");
        int input = TextIO.getlnInt();
        switch(input) {
            case(1): {
            board[x][y] = new Queen();
            }
            case(2): {
            board[x][y] = new Rook();
            }
            case(3): {
            board[x][y] = new Bishop();
            }
            case(4): {
            board[x][y] = new Knight();
            }
        }
    }
}
