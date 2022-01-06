package com.racing.model;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class RacingCarGroups {

    private final List<Car> racingCarGroups;

    private RacingCarGroups(List<Car> racingCarGroups) {
        this.racingCarGroups = racingCarGroups;
    }

    //자동차 이름으로 RacingCarGroups 생성
    public static RacingCarGroups createCarGroupsWithName(List<String> carName) {
        return new RacingCarGroups(createCarWithName(carName));
    }

    public List<CarInfo> getWinner() {
        return getMostFarAwayCarInfo(getMostFarAwayPosition());
    }

    public List<CarInfo> findNameWithPosition() {
        return racingCarGroups.stream()
                .map(CarInfo::new)
                .collect(toList());
    }

    //조건(isMovePossible)참일 경우 자동차 전진
    public void race(Predicate<Car> isMovePossible) {
        racingCarGroups.stream()
                .filter(isMovePossible)
                .forEach(Car::moveForward);
    }

    private static List<Car> createCarWithName(List<String> carName) {
        return carName.stream()
                .map(Car::createCar)
                .collect(toList());
    }

    private int getMostFarAwayPosition() {
        return racingCarGroups.stream()
                .map(Car::currentPosition)
                .max(maxComparator())
                .get().intValue();
    }

    private List<CarInfo> getMostFarAwayCarInfo(int mostFarAwayPosition) {
        return racingCarGroups.stream()
                .filter(car -> currentPosition(car) == mostFarAwayPosition)
                .map(CarInfo::new)
                .collect(toList());
    }

    private int currentPosition(Car car) {
        return car.currentPosition();
    }

    private Comparator<Integer> maxComparator() {
        return Comparator.comparing(x -> x);
    }

}
