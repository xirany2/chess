public abstract class chess{
    public player owner;
    public abstract boolean canMove();
    public abstract void move();
    protected int x;
    protected int y;
    public chess(player player1) {
        owner = player1;
    }
}