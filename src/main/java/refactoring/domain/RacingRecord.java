package refactoring.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRecord {

	private final List<Car> cars;

	public RacingRecord(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getRecords() {
		return cars;
	}

	public List<Car> winRacingCars() {
		Car maxDistanceCar = getMaxDistanceCar();

		return cars.stream()
				.filter(car -> car.sameWinnerCarDistance(maxDistanceCar))
				.collect(Collectors.toList());
	}

	private Car getMaxDistanceCar() {
		return cars.stream()
			.max(Comparator.comparingInt(Car::getCarDistance))
			.orElseThrow(IndexOutOfBoundsException::new);
	}
}