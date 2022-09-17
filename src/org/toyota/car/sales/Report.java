package org.toyota.car.sales;

import org.toyota.car.cartype.Car;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private String managerName;
    private List<Car> cars = new ArrayList<>();

    public Report(String managerName) {
        this.managerName = managerName;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
