import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("E:\\genspark1111111\\HangmanProject4\\src\\java\\words.txt"));
            Scanner inputScanner = new Scanner(System.in);
            List<String> words=new ArrayList<>();

            while(fileScanner.hasNextLine()){
                words.add(fileScanner.nextLine());
            }
            String nextGame = "yes";
            while (nextGame.equals("yes")) {

                Random random = new Random();

                String word = words.get(random.nextInt(words.size()));

                List<Character> playerGuesses = new ArrayList<>();

                int wrongTries = 0;

                while (true) {
                    System.out.println(printHangedMan(wrongTries));

                    if (wrongTries >= 6) {
                        System.out.println("You lost!");
                        System.out.println("The word is   \"" + word + "\"");
                        System.exit(0);
                    }


                    if (printGameState(word, playerGuesses)) {
                        System.out.println("Yes! The secret word is \"" + word + "\"! You have won!");
                        System.out.println("Do you want to play again? (yes or no)");
                        nextGame = inputScanner.nextLine();
                        break;
                    }
                    if (!getPlayerGuess(inputScanner, word, playerGuesses)) {
                        wrongTries++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static String printHangedMan(int tries) {

        if (tries ==0){
            return """
                     +---+
                         |
                         |
                         |
                         |
                         ====
                    """;
        }
        else if (tries == 1){
            return """
                     +---+
                      O  |
                         |
                         |
                         |
                         ====
                    """;
        }
        else if (tries == 2) {
            return """
                     +---+
                      O  |
                     \\   |
                         |
                         |
                         ====
                    """;
        }
        else if (tries == 3) {
            return """
                     +---+
                      O  |
                     \\ / |
                         |
                         |
                         ====
                    """;
        }
        else if (tries == 4) {
            return """
                     +---+
                      O  |
                     \\ / |
                      |  |
                         |
                         ====
                    """;
        }
        else if (tries == 5) {
            return """
                     +---+
                      O  |
                     \\ / |
                      |  |
                     /   |
                         ====
                    """;
        }
        else if (tries == 6) {
            return """
                     +---+
                      O  |
                     \\ / |
                      |  |
                     / \\ |
                         ====
                    """;
        }

        return "";
    }

    private static boolean getPlayerGuess(Scanner inputScanner, String word, List<Character> playerGuesses) {
        String letterGuess;
        while (true) {
            System.out.println("Guess a letter");
            letterGuess = inputScanner.nextLine().toLowerCase();
            if (playerGuesses.contains(letterGuess.charAt(0))){
                System.out.println("You have already guessed that letter. Choose again.");
            } else {
                playerGuesses.add(letterGuess.charAt(0));
                break;
            }
        }

        return word.contains(letterGuess);
    }

    public static boolean printGameState(String word, List<Character> playerGuesses) {
        int count = 0;

        System.out.print("Missed letters: ");
        for (int i = 0; i < playerGuesses.size(); i++) {
            if (!word.contains(String.valueOf(playerGuesses.get(i)))) {
                System.out.print(playerGuesses.get(i));
            }
        }

        System.out.println("");

        for (int i = 0; i < word.length(); i++){
            if (playerGuesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                count++;
            } else {
                System.out.print("-");
            }
        }

        System.out.println("");

        return word.length() == count;
    }
}
