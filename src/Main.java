import java.lang.reflect.WildcardType;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Main
{
    public static void main(String[] args)
    {
        printRules();
        Board board = new Board(6);
        Time time = new Time(board);
        Thread timeThread = new Thread(time);
        timeThread.start();

        Thread boardThread = new Thread(board);

        boardThread.start();

    }

    private static void printRules()
    {
        System.out.println("================================");
        System.out.println("Welcome to my game");
        System.out.println("Your character 'X' is slowly falling down");
        System.out.println("Your target is to move your character in any direction, so it won't fall beyond the board ");
        System.out.println("Controls:");
        System.out.println("Up-W\nDown-S\nLeft-A\nRight-D");
        System.out.println("In order to begin, input any key :)");
        System.out.println("================================");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}