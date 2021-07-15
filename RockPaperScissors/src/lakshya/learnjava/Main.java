package lakshya.learnjava;

import java.util.*;


public class Main {

    private static final int ROCK = 0; //beats Scissors -> ROCK = (SCISSORS + 1) % 3
    private static final int PAPER = 1; //beats Rock -> PAPER = (ROCK + 1) % 3
    private static final int SCISSORS = 2; //beats Paper -> SCISSORS = (PAPER + 1) % 3

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
            if(playerValue == computerValue){
                System.out.println("Draw!");
            } else if(playerValue == (computerValue + 1) % 3){
                System.out.println("You Win!");
            } else{
                System.out.println("Computer Wins!");
            }

            System.out.printf("Play again? (y/n): ");
            response = scanner.nextLine().toLowerCase();
        }
        System.out.println("Good Bye!");
        scanner.close();
    }
}
