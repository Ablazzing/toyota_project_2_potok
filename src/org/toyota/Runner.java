package org.toyota;

import org.toyota.car.details.*;
import org.toyota.car.models.Camry;
import org.toyota.car.models.Solara;

public class Runner {
    public static void main(String[] args) {
        GasTank gasTank = new GasTank();
        Engine engine = new Engine();
        Electrics electrics = new Electrics();
        HeadLights headLights = new HeadLights();
        Wheel[] wheels = generateWheels(CarWheelRadius.R17);
        CruiseControl cruiseControl = new CruiseControl();
        Usb usb = new Usb();

        Camry camry = new Camry("black", 250, TransmissionType.AUTOMATIC, false, 10000,
                gasTank, wheels, engine, electrics, headLights, CarWheelRadius.R17, cruiseControl, usb);
        camry.onMusic();
    }

    public static Wheel[] generateWheels(CarWheelRadius carWheelRadius) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel(carWheelRadius);
        }
        return wheels;
    }
}
