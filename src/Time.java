public class Time implements Runnable
{
    Board board;

    public Time(Board board)
    {
        this.board = board;
    }

    @Override
    public void run()
    {
        boolean isAlive=true;
        for(int i=0;true;i++)
        {
            try
            {
                Thread.sleep(2000);
                isAlive = board.moveEverythingOneDown();
                if(!isAlive)
                {
                    System.out.println("You have lost!");
                    System.out.println("Your time alive: " + i*2);
                    System.exit(0);
                }
                board.printBoard();
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
