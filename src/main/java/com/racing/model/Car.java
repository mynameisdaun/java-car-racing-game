package com.racing.model;

import static com.racing.constant.Constant.*;

public class Car {

    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = CAR_DEFAULT_POSITION;
    }

    public static Car createCar(String name) throws RuntimeException{
        if(isBlank(name)) {
            throw new IllegalArgumentException(MESSAGE_ERROR_CAR_NAME_BLANK);
        }
        if(isLengthOutOfLimit(name)) {
            throw new IllegalArgumentException(MESSAGE_ERROR_CAR_NAME_OUT_OF_LIMIT);
        }
        return new Car(name);
    }

    private static boolean isLengthOutOfLimit(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    private static boolean isBlank(String name) {
        return name == null || "".equals(name) || " ".equals(name);
    }

    public void moveForward() {
        ++position;
    }

    public int currentPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
