package lakshya.learnjava;

import java.util.*;


public class Main {

    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomGenerator = new Random();
        ArrayList<String> moves = new ArrayList<>(List.of("Rock","Paper","Scissors"));
        String playerChoice;
        String response = "y";
        while(response.equals("y")) {
            int playerValue = -1;
            int computerValue = randomGenerator.nextInt(3);
            while (playerValue == -1) {
                System.out.println("Please Enter rock, paper or scissors");
                playerChoice = scanner.nextLine().toLowerCase();

                if (playerChoice.equals("rock")) {
                    playerValue = ROCK;
                } else if (playerChoice.equals("paper")) {
                    playerValue = PAPER;
                } else if (playerChoice.equals("scissors")) {
                    playerValue = SCISSORS;
                } else {
                    System.out.println("Invalid move!");
                }
            }

            System.out.println("Computer's move: " + moves.get(computerValue));
            if (Math.abs(playerValue - computerValue) == 1) {
                if (playerValue > computerValue) {
                    System.out.println("You Win!");
                } else {
                    System.out.println("You Lose!");
                }
            } else if (Math.abs(playerValue - computerValue) == 2) {
                if (playerValue > computerValue) {
                    System.out.println("You Lose!");
                } else {
                    System.out.println("You Win!");
                }
            } else {
                System.out.println("Draw!");
            }

            System.out.printf("Play again? (y/n): ");
            response = scanner.nextLine().toLowerCase();
        }
        System.out.println("Good Bye!");
        scanner.close();
    }
}
