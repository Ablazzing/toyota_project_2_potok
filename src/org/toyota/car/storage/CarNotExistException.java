package org.toyota.car.storage;

public class CarNotExistException extends Exception {
    public CarNotExistException(String message) {
        super(message);
    }
}
