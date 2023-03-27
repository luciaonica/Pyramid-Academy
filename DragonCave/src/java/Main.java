import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static String result(int cave){
        if (cave == 1) {
            return """
                    You approach the cave...
                    It is dark and spooky...
                    A large dragon jumps out in front of you! He opens his jaws and...
                    Gobbles you down in one bite!
                    """;


        } else if (cave == 2){
            return "Welcome!";
        } else {
            return "Wrong answer!";
        }
    }

    public static void main(String[] args) {
        System.out.println("You are in a land full of dragons. In fron of you, \nyou see two caves. "
                + "In one cave, the dragon is friendly \nand will share his treasure with you. "
                + "The other dragon \nis greedy and hungry and will eat you on sight.\n"
                + "Which cave will you go into? (1 or 2)\n");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int chosenCave = Integer.parseInt(br.readLine());
            System.out.println(result(chosenCave));
        } catch(Exception ex) {
            System.err.println("Invalid Format!");
        }

    }
}