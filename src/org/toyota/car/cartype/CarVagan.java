package org.toyota.car.cartype;

import org.toyota.car.details.*;
import org.toyota.car.factory.Country;

public abstract class CarVagan extends Car {
    private int maxWeightTaken;

    public CarVagan(String color, int maxSpeed, TransmissionType transmissionType, boolean isMove, double price,
                    GasTank gasTank, Wheel[] wheels, Engine engine, Electrics electrics, HeadLights headLights,
                    CarWheelRadius carWheelRadius, int maxWeightTaken, Country country) {
        super(color, maxSpeed, transmissionType, isMove, price, gasTank, wheels, engine, electrics, headLights,
                carWheelRadius, country);
        this.maxWeightTaken = maxWeightTaken;
    }

    public int getMaxWeightTaken() {
        return maxWeightTaken;
    }
}
