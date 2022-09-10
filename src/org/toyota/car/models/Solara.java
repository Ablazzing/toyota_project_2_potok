package org.toyota.car.models;

import org.toyota.car.cartype.Cabriolet;
import org.toyota.car.details.*;
import org.toyota.car.factory.Country;

public class Solara extends Cabriolet {
    private MiniFridge miniFridge;

    public Solara(String color, int maxSpeed, TransmissionType transmissionType, boolean isMove, double price,
                  GasTank gasTank, Wheel[] wheels, Engine engine, Electrics electrics, HeadLights headLights,
                  CarWheelRadius carWheelRadius, Roof roof, MiniFridge miniFridge, Country country) {
        super(color, maxSpeed, transmissionType, isMove, price, gasTank, wheels, engine, electrics, headLights,
                carWheelRadius, roof, country);
        this.miniFridge = miniFridge;
    }

    public void fridge() {
        miniFridge.fridge();
    }
}
