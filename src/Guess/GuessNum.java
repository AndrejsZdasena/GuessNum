package Guess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Random random = new Random();

        String userName = askName("Enter you name");

        do {

            int MyNum = random.nextInt(100) + 1;
            System.out.println("I'm thinking of number from 1 to 100 try to guess it");
            boolean UserWin = false;


            for (int attempt = 1; attempt <= 10; attempt++) {


                System.out.printf("Attempts %d\n", attempt);

                int UserNum = askNumber("Enter the number what i'm thinking for", 1, 100);

                if (MyNum > UserNum) {

                    System.out.println("Your number is too low");

                } else if (MyNum < UserNum) {

                    System.out.println("Your number is too high");

                } else {

                    System.out.printf("You won! Attempts were used %d\n ", attempt);

                    UserWin = true;

                    break;
                }

            }

            if (!UserWin) {
                System.out.printf("You lost! My number was: %d\n", MyNum);

            }

            askYesNo("Do you want to play again Y/n");

        } while (!scanner.next().equals("n"));

        System.out.print("Good Bye! " + userName);

    }

    public static int askNumber(String msg, int min, int max) {
        while (true) {
            System.out.print(msg + ":\n");
            try {
                int result = scanner.nextInt();

                if (result < min) {
                    System.err.println("Number should not be less than " + min);
                    continue;
                } else if (result > max) {
                    System.err.println("Number should not be high than " + max);
                    continue;
                }

                return result;
            } catch (InputMismatchException e) {
                String input = scanner.next();
                System.err.println("This is not a number " + input);
            }

        }
    }

    public static String askName(String name) {
        System.out.print(name + ":\n ");
        return scanner.next();
    }

    public static void askYesNo(String msg) {
        System.out.print(msg + ": ");
        scanner.next();
    }
}


