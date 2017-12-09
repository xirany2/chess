import java.util.Scanner;
public class Driver{
    public static void main(String argc[]) {
    	Scanner scan = new Scanner(System.in);
    System.out.print("Please type name for player 1: ");
    Player player1 = new Player(scan.nextLine());
    System.out.print("Please type name for player 2: ");
    Player player2 = new Player(scan.nextLine());
    System.out.println(player1.name + " vs " + player2.name);
    Game gameBoard = new Game(player1, player2);
    boolean ip = false;
    int[] a = new int[4];
    while (gameBoard.winner == null) {
        if (gameBoard.player2Turn) {
           System.out.println(player2.name + ", your turn! ");
           System.out.println();
           for (int i = 8; i >= 1; i--) {
               for (int  j = 1; j <= 8; j++) {
                   if (gameBoard.board2[j][i] == null) {
                	   System.out.print("Empty");
                       for (int k = 1; k <= 15; k++)System.out.print(" ");
                   } else if (gameBoard.board2[j][i].owner == player2) {
                       System.out.print("Yours:  " + gameBoard.board2[j][i].name);
                   } else {
                       System.out.print("Others: " + gameBoard.board2[j][i].name);
                   }
               }
               for (int k = 0; k <= 4; k++) {
                   System.out.println();
               }
           }
           System.out.println("Please type four number as the operation: ");
           for (int i = 0; i <= 3; i++) {
               a[i] = scan.nextInt();
           }
          ip = gameBoard.move(a[0],a[1],a[2],a[3]);
        } else  {
            System.out.println(player1.name + ", your turn! ");
            System.out.println();
           for (int i = 8; i >= 1; i--) {
               for (int  j = 1; j <= 8; j++) {
                   if (gameBoard.board1[j][i] == null) {
                	   System.out.print("Empty");
                       for (int k = 1; k <= 15; k++)System.out.print(" ");
                   } else if (gameBoard.board1[j][i].owner == player1) {
                       System.out.print("Yours:  " + gameBoard.board1[j][i].name);
                   } else {
                       System.out.print("Others: " + gameBoard.board1[j][i].name);
                   }
               }
               for (int k = 0; k <= 4; k++) {
                   System.out.println();
               }
           }
           System.out.println("Please type four number as the operation: ");
           for (int i = 0; i <= 3; i++) {
        	   a[i] = scan.nextInt();
           }
           ip = gameBoard.move(a[0],a[1],a[2],a[3]);
        }
    }
    System.out.println("Congratulations, the winner is " + gameBoard.winner.name);
    }
}