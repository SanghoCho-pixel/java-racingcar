package study03.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("전진")
    void forward(int condition) throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car();
        car.moveOnSatisfiedCondition(condition);

        Field position = Car.class.getDeclaredField("position");
        position.setAccessible(true);
        Integer actualPosition = (Integer) position.get(car);

        assertThat(actualPosition).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("움직이지 않음")
    void hold(int condition) throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car();
        car.moveOnSatisfiedCondition(condition);

        Field position = Car.class.getDeclaredField("position");
        position.setAccessible(true);
        Integer actualPosition = (Integer) position.get(car);

        assertThat(actualPosition).isEqualTo(0);
    }

}