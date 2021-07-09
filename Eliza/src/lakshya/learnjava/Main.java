package lakshya.learnjava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println(Doctor.intro());
        String userInput = "";
        while(!userInput.equalsIgnoreCase("quit")){
            userInput = scanner.nextLine();
            String response = Doctor.response(userInput);
            System.out.println(response);
        }
        scanner.close();
    }
}
