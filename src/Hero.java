public class Hero
{
    private int x=0;
    private int y=0;

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean setPosition(int x, int y)
    {
        if( x<0 || y<0 || x>=Board.BOARD_SIZE || y>=Board.BOARD_SIZE)
        {
            return false;
        }

        this.x = x;
        this.y = y;
        return true;
    }

    public void printPosition()
    {
        System.out.println("x: " + this.x + " y: " + this.y);
    }
}
