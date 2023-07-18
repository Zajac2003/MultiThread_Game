import java.util.Scanner;

public class Board implements Runnable
{
    public static int BOARD_SIZE;
    Hero hero = new Hero();

    char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    public Board(int BOARD_SIZE)
    {
        this.BOARD_SIZE = BOARD_SIZE;
        board = new char[BOARD_SIZE][BOARD_SIZE];
        fillBoard(this.BOARD_SIZE);
    }

    public void moveHeroWithKeyboard(char direction)
    {
        if(direction == 'W')
        {
            hero.setPosition(hero.getX()-1, hero.getY());
            changeHeroPositionOnBoard();
        }
        else if(direction == 'S')
        {
            hero.setPosition(hero.getX()+1, hero.getY());
            changeHeroPositionOnBoard();
        }
        else if(direction == 'A')
        {
            hero.setPosition(hero.getX(), hero.getY()-1);
            changeHeroPositionOnBoard();
        }
        else if(direction == 'D')
        {
            hero.setPosition(hero.getX(), hero.getY()+1);
            changeHeroPositionOnBoard();
        }
        hero.printPosition();
    }

    public void printBoard()
    {
        for(int i=0;i<BOARD_SIZE;i++)
        {
            for(int j=0;j<BOARD_SIZE;j++)
            {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void fillBoard(int size)
    {
        for(int i=0;i<BOARD_SIZE;i++)
        {
            for(int j=0;j<BOARD_SIZE;j++)
            {
                this.board[i][j] = '0';
            }
        }
        this.board[hero.getX()][hero.getY()] = 'X';
    }

    private void changeHeroPositionOnBoard()
    {
        for(int i=0;i<BOARD_SIZE;i++)
        {
            for(int j=0;j<BOARD_SIZE;j++)
            {
                board[i][j] = board[i][j] == 'X' ? '0' : board[i][j];
            }
        }

        for(int i=0;i<BOARD_SIZE;i++)
        {
            for(int j=0;j<BOARD_SIZE;j++)
            {
                board[i][j] = (i == hero.getX() && j == hero.getY()) ? 'X' : board[i][j];
            }
        }
    }

    public boolean moveEverythingOneDown()
    {
        for(int i=BOARD_SIZE-1;i>=0;i--)
        {
            for(int j=0;j<BOARD_SIZE;j++)
            {
                if(board[i][j]=='X' && i==BOARD_SIZE-1)// jesli w ostatnim rzedzie heros ('X')
                    return false;
                else if( i>0)//przenies
                {
                    if(board[i][j] == 'X')
                    {
                        hero.setPosition(hero.getX()+1, hero.getY());
                        changeHeroPositionOnBoard();
                        board[i-1][j] = '0';
                    }
                    else board[i][j] = board[i-1][j];
                }
                else    // wypelnij pierwszy rzad pustymi
                {
                    if(board[i][j] == 'X')
                    {
                        hero.setPosition(hero.getX()+1, hero.getY());
                        changeHeroPositionOnBoard();
                    }
                    board[i][j] = '0';
                }
            }
        }
        return true;
    }


    @Override
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        String directionString = new String();
        char directionChar;

        while(true)
        {
            printBoard();
            directionString = scanner.nextLine();
            try
            {
                directionChar = directionString.charAt(0);
                moveHeroWithKeyboard(directionChar);
            }
            catch(Exception e)
            {}
        }
    }
}
