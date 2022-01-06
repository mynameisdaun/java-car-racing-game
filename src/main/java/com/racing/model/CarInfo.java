package com.racing.model;

import com.racing.model.Car;

public class CarInfo {

    private final String name;
    private final int position;

    public CarInfo(Car car) {
        this.name = car.getName();
        this.position = car.currentPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
