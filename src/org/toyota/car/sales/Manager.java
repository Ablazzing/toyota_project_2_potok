package org.toyota.car.sales;

import org.toyota.car.cartype.Car;
import org.toyota.car.factory.AssemblyCar;
import org.toyota.car.storage.CarNotExistException;
import org.toyota.car.storage.CarStorage;

public class Manager {
    private CarStorage carStorage;
    private AssemblyCar assemblyCar;

    public Manager(CarStorage carStorage, AssemblyCar assemblyCar) {
        this.carStorage = carStorage;
        this.assemblyCar = assemblyCar;
    }

    public Car saleCar(Customer customer) throws CustomerHasNoMoneyException {
        if (customer.getMoney() >= ModelPrice.DYNA.getPrice()) {
            try {
                return carStorage.getDyna();
            } catch (CarNotExistException e) {
                return assemblyCar.createDyna("black", ModelPrice.DYNA.getPrice());
            }
        } else if (customer.getMoney() >= ModelPrice.HIANCE.getPrice()) {
            try {
                return carStorage.getHiance();
            } catch (CarNotExistException e) {
                return assemblyCar.createHiance("black", ModelPrice.HIANCE.getPrice());
            }
        } else if (customer.getMoney() >= ModelPrice.SOLARA.getPrice()) {
            try {
                return carStorage.getSolara();
            } catch (CarNotExistException e) {
                return assemblyCar.createSolara("black", ModelPrice.SOLARA.getPrice());
            }
        } else if (customer.getMoney() >= ModelPrice.CAMRY.getPrice()) {
            try {
                return carStorage.getCamry();
            } catch (CarNotExistException e) {
                return assemblyCar.createCamry("black", ModelPrice.CAMRY.getPrice());
            }
        }

        throw new CustomerHasNoMoneyException("У клиента " + customer.getName() + " нет денег");
    }
}
