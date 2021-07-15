package lakshya.learnjava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Car lambhorgini = new Car("Lambhorgini");
        Game game = new Game();
        game.play(lambhorgini);
    }
    
}

class Game {
    private static final String ROAD = "|                             |";
    private static final String CAR_SYMBOL = "V";

    // Control keys
    private static final char LEFT = 'a';
    private static final char STRAIGHT = 's';
    private static final char RIGHT = 'd';
    private static final char ACCELERATE = 'w';
    private static final char BRAKE = 'x';
    private static final char INFO = 'i';
    private static final char QUIT = 'q';

    private static final int DIR_LEFT = -1;
    private static final int DIR_RIGHT = 1;
    private static final int DIR_STRAIGHT = 0;

    private static final StringBuilder BUILDER = new StringBuilder();

    public static void play(Car c){
        Scanner scanner = new Scanner(System.in);

        char control;
        boolean playing = true;
        int accelerationFactor = 1;
        int carPosition = 15;

        // Instructions
        printInstructions();

        do {
            control = scanner.nextLine().toLowerCase().charAt(0);
            if (Character.isDigit(control)) {
                accelerationFactor = control - '0';
            } else {
                switch (control) {
                    case LEFT:
                        carPosition = drawRoad(carPosition, c.getSpeed(), DIR_LEFT);
                        break;
                    case STRAIGHT:
                        carPosition = drawRoad(carPosition, c.getSpeed(), DIR_STRAIGHT);
                        break;
                    case RIGHT:
                        carPosition = drawRoad(carPosition, c.getSpeed(), DIR_RIGHT);
                        break;
                    case ACCELERATE:
                        c.accelerate(accelerationFactor);
                        break;
                    case BRAKE:
                        c.brake(accelerationFactor);
                        break;
                    case INFO:
                        c.showSpeed();
                        break;
                    case QUIT:
                        playing = false;
                        break;
                }
                if(carPosition == -1){
                    System.out.println("OOPS! You Crashed! Game Over");
                    playing = false;
                }
            }
        } while (playing);
        scanner.close();
    }

    public static void printInstructions(){
        System.out.println("Welcome to the Console Grand Prix");
        System.out.println("=================================");
        System.out.println();
        System.out.printf("Control your car by pressing '%s' to go left, and '%s' to go right.%n", LEFT, RIGHT);
        System.out.printf("'%s' will go straight.%n", STRAIGHT);
        System.out.println();
        System.out.println("The faster your car's going, the further down the track it");
        System.out.println("will travel in the chosen direction.  Watch out for the bends!");
        System.out.println();
        System.out.println("Choose the acceleration/deceleration factor by pressing a number key.");
        System.out.printf("You can press a number key anytime before using '%s' or '%s'.%n", ACCELERATE, BRAKE);
        System.out.printf("Pressing '%s' will accelerate by that amount,%n", ACCELERATE);
        System.out.printf("'%s' will brake by that amount.%n", BRAKE);
        System.out.println();
        System.out.println("Your car starts off stationary, so you'll need to accelerate before you can move.");
        System.out.println();
        System.out.printf("Press '%s' to find out your current speed.%n", INFO);
        System.out.println();
        System.out.printf("'%s' will quit.%n", QUIT);
    }

    private static int drawRoad(int carPos, int speed, int direction) {
        for (int i = 0; i < speed; i++) {
            carPos += direction;
            if(carPos >= ROAD.length() || carPos <= 0){
                return -1;
            }
            buildRoad(carPos);
        }
        System.out.println(BUILDER.toString());
        return carPos;
    }

    private static void buildRoad(int carPosition) {
        // insert car symbol in the "road"
        String roadLine = ROAD.substring(0, carPosition) + CAR_SYMBOL + ROAD.substring(carPosition) + "\n";

        // add to builder with line separator
        BUILDER.append(roadLine);
    }

}


class Car {

    private int speed;
    private String name;

    public Car(String carName) {
        name = carName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void accelerate(int amount) {
        speed += amount;  // Speed = Speed + amount;
        showSpeed();
    }

    public void brake(int speedReduction) {
        speed = (speed < speedReduction) ? 0 : speed - speedReduction;
        showSpeed();
    }

    public void showSpeed() {
        System.out.printf("%s is going %s miles per hour.%n", name, speed * 10);
    }
}