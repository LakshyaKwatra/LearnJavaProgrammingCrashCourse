package lakshya.learnjava;

public class Main {

    public static void main(String[] args) {
        Car myCar = new Car("XUV-500");
        Car anotherCar = new Car("Scorpio",10);
        for(int i = 0; i < 5; i++){
            myCar.accelerate();
        }
        myCar.brake();
        anotherCar.accelerate();
        myCar.accelerate();
        myCar.brake();
        anotherCar.accelerate();
        anotherCar.brake();

    }
}

class Car {

    private int speed = 0, pickup = 5;
    private String name;

    public Car(String carName){
        name = carName;
    }
    public Car(String carName, int pickup){
        name = carName;
        this.pickup = pickup;
    }
    private void showSpeed(){
        System.out.printf("%s is going at %d km/h!\n", name, speed);
    }
    public void accelerate(){
        speed += pickup;
        showSpeed();
    }
    public void brake(){
        if(speed >= 5) speed -= pickup;
        showSpeed();
    }
}
