package study03.model;

import java.util.Optional;
import java.util.function.Predicate;

/*
 *
 * Car
 *
 * @version 1.0.0
 *
 * 2021-11-10
 *
 * Copyright tnals1422
 */
public class Car {

    private static final int CRITERIA = 4;
    private int position = 0;

    public void moveOnSatisfiedCondition(int condition) {
        Optional.of(condition)
                .filter(isForward())
                .ifPresent(x -> position++);
    }

    private Predicate<Integer> isForward() {
        return number -> number >= CRITERIA;
    }

    public int getPosition() {
        return position;
    }
}