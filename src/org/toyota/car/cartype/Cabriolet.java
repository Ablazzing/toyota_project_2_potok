package org.toyota.car.cartype;

import org.toyota.car.details.*;
import org.toyota.car.factory.Country;

public abstract class Cabriolet extends Car {
    private Roof roof;

    public Cabriolet(String color, int maxSpeed, TransmissionType transmissionType, boolean isMove, double price,
                     GasTank gasTank, Wheel[] wheels, Engine engine, Electrics electrics, HeadLights headLights,
                     CarWheelRadius carWheelRadius, Roof roof, Country country) {
        super(color, maxSpeed, transmissionType, isMove, price, gasTank, wheels, engine, electrics, headLights,
                carWheelRadius, country);
        this.roof = roof;
    }

    public void turnRoof() {
        roof.turn();
    }
}
