import java.util.Scanner;

public class Main {
    static Scanner br;
    static String name;

    public static String guessTheNumber(String name){
        br = new Scanner(System.in);
        int number = Main.generateTheNumber();
        int numberOfTotalTrials = 6;
        int numberOfUsersTrials, guess;

        for (numberOfUsersTrials = 1; numberOfUsersTrials <= numberOfTotalTrials; numberOfUsersTrials++){
            System.out.println("\nTake a guess.");
            try {
                guess = Integer.parseInt(br.nextLine());

                if (endOfGame(guess, number, numberOfUsersTrials, numberOfTotalTrials)) break;

            } catch (Exception e) {
                System.err.println("Invalid Format!");
            }
        }

        return (numberOfUsersTrials == numberOfTotalTrials + 1) ? "You lost" : "";
    }

    public static boolean endOfGame(int guess, int number, int numberOfUsersTrials, int numberOfTotalTrials) {
        if (guess == number) {
             System.out.println("Good job, " + name + "! You guessed my number in " + numberOfUsersTrials + " guesses!\n"
                    + "Would you like to play again?(y or n)");
            return true;

        } else if (guess < number && numberOfUsersTrials != numberOfTotalTrials){
            System.out.println("\nYour guess is too low.");

        } else if (guess > number && numberOfUsersTrials != numberOfTotalTrials){
            System.out.println("\nYour guess is too high.");
        }
        return false;
    }

    public static int generateTheNumber() {
        return (int) Math.floor(Math.random() * 20) + 1;
    }

    public static void main(String[] args)  {

        System.out.println("Hello! What is your name?\n");
        br = new Scanner(System.in);

        try {
            name = br.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
        String newGame = "y";

        while (newGame.equals("y")) {
            System.out.println(guessTheNumber(name));
            newGame = br.nextLine();
        }
    }
}
