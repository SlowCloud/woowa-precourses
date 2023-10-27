package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarDistanceMessage> forwardCars() {

        List<CarDistanceMessage> messages = new ArrayList<>();

        for (Car car : cars) {
            RandomNumber number = RandomNumber.createRandomNumber();
            if (number.isMovable()) car.move();
        }

        for (Car car : cars) {
            messages.add(car.createCarDistanceMessage());
        }

        return messages;

    }

}
