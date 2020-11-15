package racingcar.domain.car;

import racingcar.strategy.MovingStrategy;

public class Car {

    private final Name name;
    private Position position;
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVING_DISTANCE = 1;

    public Car(Name name) {
        this(name, new Position(DEFAULT_POSITION));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(MovingStrategy movableGenerator) {
        if (movableGenerator.isMovable()) {
            int currentPosition = this.position.getValue();
            this.position = new Position(currentPosition + MOVING_DISTANCE);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return this.name.getValue().equals(car.getName().getValue()) &&
                this.position.getValue() == car.getPosition().getValue();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean isEqualPositionValue(int positionValue) {
        return this.position.getValue() == positionValue;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}