package org.toyota.car.models;

import org.toyota.car.cartype.CarVagan;
import org.toyota.car.details.*;
import org.toyota.car.factory.Country;

public class Dyna extends CarVagan {
    private Socket socket;

    public Dyna(String color, int maxSpeed, TransmissionType transmissionType, boolean isMove, double price,
                GasTank gasTank, Wheel[] wheels, Engine engine, Electrics electrics, HeadLights headLights,
                CarWheelRadius carWheelRadius, int maxWeightTaken, Socket socket, Country country) {
        super(color, maxSpeed, transmissionType, isMove, price, gasTank, wheels, engine, electrics, headLights,
                carWheelRadius, maxWeightTaken, country);
        this.socket = socket;
    }

    public void chargePhone() {
        this.socket.chargePhone();
    }
}
