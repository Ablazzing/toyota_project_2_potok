package org.toyota.car.factory;

import org.toyota.car.details.*;

public class DetailsFactory {
    private Country country;

    public DetailsFactory(Country country) {
        this.country = country;
    }

    public Electrics createElectrics() {
        return new Electrics();
    }

    public Engine createEngine() {
        return new Engine();
    }

    public GasTank createGasTank() {
        return new GasTank(0);
    }

    public HeadLights createHeadLights() {
        return new HeadLights();
    }

    public MiniFridge createMiniFridge() {
        return new MiniFridge();
    }

    public Socket createSocket() {
        return new Socket();
    }

    public Usb createUsb() {
        return new Usb();
    }

    public Roof createRoof() {
        return new Roof();
    }

    public CruiseControl createCruiseControl() {
        return new CruiseControl();
    }

    public Wheel[] createWheels(CarWheelRadius carWheelRadius) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel(carWheelRadius);
        }
        return wheels;
    }

    public Wheel createSafeWheel(CarWheelRadius carWheelRadius) {
        return new Wheel(carWheelRadius);
    }

    public Country getCountry() {
        return country;
    }
}
