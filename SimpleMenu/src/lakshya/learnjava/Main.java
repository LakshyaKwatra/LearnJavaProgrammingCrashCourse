package lakshya.learnjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response = "y";
        ArrayList<String> menu = new ArrayList<>(List.of("Cappuccino",
                "Latte",
                "Americano",
                "Mocha",
                "Machiato",
                "Espresso"));

        while(response.equals("y") || response.equals("Y")) {
            System.out.println("Please Choose Your Coffee");
            for(int i = 1; i <= menu.size(); i++){
                System.out.printf("%d: %s\n", i, menu.get(i - 1));
            }
            System.out.println("Q: Quit");

            String userChoice = scanner.nextLine();
            try {
                if (!userChoice.equals("q") && !userChoice.equals("Q")) {
                    System.out.println("Here's your " + menu.get(Integer.parseInt(userChoice) - 1) + "!");
                } else {
                    System.out.println("Good Bye!");
                    break;
                }
            } catch (Exception e){
                System.out.println(e);
            }
            System.out.printf("Do you want more coffee? (y/n): ");
            response = scanner.nextLine();
        }
        scanner.close();
    }
}
