package org.toyota.car.models;

import org.toyota.car.cartype.Sedan;
import org.toyota.car.details.*;
import org.toyota.car.factory.Country;

public class Camry extends Sedan {
    private Usb usb;

    public Camry(String color, int maxSpeed, TransmissionType transmissionType, boolean isMove, double price,
                 GasTank gasTank, Wheel[] wheels, Engine engine, Electrics electrics, HeadLights headLights,
                 CarWheelRadius carWheelRadius, CruiseControl cruiseControl, Usb usb, Country country) {
        super(color, maxSpeed, transmissionType, isMove, price, gasTank, wheels, engine, electrics, headLights,
                carWheelRadius, cruiseControl, country);
        this.usb = usb;
    }

    public void onMusic() {
        usb.musicOn();
    }
}
