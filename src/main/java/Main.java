import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Race currentRace = new Race();

        for (int i = 1; i < 4; i++) {
            System.out.println("— Введите название машины № " + i);
            String carName = in.next();
            System.out.println("— Введите скорость машины № " + i);
            int carSpeed = in.nextInt();

            if (carSpeed < 0 || carSpeed > 250) {

                while (carSpeed < 0 || carSpeed > 250) {
                    System.out.println("— Неправильная скорость");
                    System.out.println("— Введите скорость машины № " + i);
                    carSpeed = in.nextInt();
                }
            }
            Car currentCar = new Car(carName, carSpeed);
            currentRace.setLeader(currentCar);
        }
        System.out.println("Самая быстрая машина: " + currentRace.leader.name);
    }
}

class Car {
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {
    Car leader;
    int distance = 0;
    public void setLeader (Car currentCar) {
        if (distance < currentCar.speed*24) {
            distance = currentCar.speed*24;
            leader = currentCar;
        }
    }

}