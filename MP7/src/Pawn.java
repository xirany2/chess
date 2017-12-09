import java.util.Scanner;
public class Pawn extends Chess{ 
    public String name = "Pawn        ";
    public Pawn(Player play){
        super(play);
        super.name = this.name;
    }
    public boolean canMove(Chess[][] board, int x1, int y1, int x2, int y2) {
        boolean flag = false;
        if (!super.canMove(board, x1, x2, y1, y2)){
            return false;
        }
        if (y2 - y1 == 1
        && x2 == x1
        && board[x2][y2] == null) {
        flag = true;
        }
        if (y1 == 2
        && y2 == 4
        && x1 == x2
       && board[x1][3] == null) {
        flag = true;
        }
        if (y2 - y1 == 1
        && x2 - x1 == 1
        && x2 - x1 == -1
        && board[x2][y2] != null) {
        flag = true;
        }
        return flag;
        }
    public void elevate(Chess[][] board, int x, int y, Player owner) {
        System.out.println("Please select which one to elevate");
        System.out.println("1: Queen; 2: Rook; 3: Bishop; 4: Knight");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        switch(in) {
            case(1): {
            board[x][y] = new Queen(owner);
            }
            case(2): {
            board[x][y] = new Rook(owner);
            }
            case(3): {
            board[x][y] = new Bishop(owner);
            }
            case(4): {
            board[x][y] = new Knight(owner);
            }
        }
    }
}
