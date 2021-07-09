package lakshya.learnjava;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        Random randomGenerator = new Random();
        int firstNumber = randomGenerator.nextInt(9) + 1;
        int secondNumber = randomGenerator.nextInt(9) + 1;
        var subtraction = randomGenerator.nextInt(9) + 1;
        int answer = firstNumber * secondNumber - subtraction;
        String prompt = ". Press ENTER when ready.";

        System.out.println("Think of a number between 1 and 10." + prompt);
        scanner.nextLine();
        System.out.println("Multiply your number by " + firstNumber + prompt);
        scanner.nextLine();
        System.out.println("Now multiply the result by " + secondNumber + prompt);
        scanner.nextLine();
        System.out.println("Divide the result by the number you originally thought of." + prompt);
        scanner.nextLine();
        System.out.println("Now subtract the result by " + subtraction + prompt);
        scanner.nextLine();
        scanner.close();
        System.out.println("The result is: "+ answer);
    }
}
