package org.toyota.car.sales;

import org.toyota.car.cartype.Car;

public class Casher {
    private static double incomes = 0;

    public void saleCar(Car car) {
        incomes += car.getPrice();
    }

    public static void getIncomes() {
        System.out.println("Доход со всех проданных машин: " + incomes);
    }
}
