package org.toyota.car.sales;

public class CustomerHasNoMoneyException extends Exception {
    public CustomerHasNoMoneyException() {
        super();
    }

    public CustomerHasNoMoneyException(String message) {
        super(message);
    }
}
