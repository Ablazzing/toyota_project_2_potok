package org.toyota.car.models;

import org.toyota.car.cartype.CarVagan;
import org.toyota.car.details.*;
import org.toyota.car.factory.Country;

public class Hiance extends CarVagan {
    private Wheel safeWheel;

    public Hiance(String color, int maxSpeed, TransmissionType transmissionType, boolean isMove, double price,
                  GasTank gasTank, Wheel[] wheels, Engine engine, Electrics electrics, HeadLights headLights,
                  CarWheelRadius carWheelRadius, int maxWeightTaken, Wheel safeWheel, Country country) {
        super(color, maxSpeed, transmissionType, isMove, price, gasTank, wheels, engine, electrics, headLights,
                carWheelRadius, maxWeightTaken, country);
        this.safeWheel = safeWheel;
    }

    public Wheel getSafeWheel() {
        return safeWheel;
    }

    public void setSafeWheel(Wheel safeWheel) {
        this.safeWheel = safeWheel;
    }
}
