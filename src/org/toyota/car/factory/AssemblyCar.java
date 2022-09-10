package org.toyota.car.factory;

import org.toyota.car.details.*;
import org.toyota.car.models.Camry;
import org.toyota.car.models.Dyna;
import org.toyota.car.models.Hiance;
import org.toyota.car.models.Solara;

public class AssemblyCar {
    private Country country;
    private DetailsFactory detailsFactory;

    public AssemblyCar(Country country, DetailsFactory detailsFactory) throws CountyFactoryNotEqualException {
        this.country = country;
        this.detailsFactory = detailsFactory;
        if (country != detailsFactory.getCountry()) {
            throw new CountyFactoryNotEqualException("Ошибка: Страна сборочного конвеера " + country
                    + " не равна стране завода " + detailsFactory.getCountry());
        }
    }

    public Camry createCamry(String color, double price) {
        Electrics electrics = detailsFactory.createElectrics();
        Engine engine = detailsFactory.createEngine();
        GasTank gasTank = detailsFactory.createGasTank();
        HeadLights headLights = detailsFactory.createHeadLights();
        Wheel[] wheels = detailsFactory.createWheels(CarWheelRadius.R17);
        Usb usb = detailsFactory.createUsb();
        CruiseControl cruiseControl = detailsFactory.createCruiseControl();

        return new Camry(color, 250, TransmissionType.AUTOMATIC, false, price, gasTank, wheels, engine,
                electrics, headLights, CarWheelRadius.R17, cruiseControl, usb, this.country);
    }

    public Solara createSolara(String color, double price) {
        Electrics electrics = detailsFactory.createElectrics();
        Engine engine = detailsFactory.createEngine();
        GasTank gasTank = detailsFactory.createGasTank();
        HeadLights headLights = detailsFactory.createHeadLights();
        Wheel[] wheels = detailsFactory.createWheels(CarWheelRadius.R16);
        Roof roof = detailsFactory.createRoof();
        MiniFridge miniFridge = detailsFactory.createMiniFridge();

        return new Solara(color, 300, TransmissionType.ROBOT, false, price, gasTank, wheels, engine,
                electrics, headLights, CarWheelRadius.R16, roof, miniFridge, this.country);
    }

    public Hiance createHiance(String color, double price) {
        Electrics electrics = detailsFactory.createElectrics();
        Engine engine = detailsFactory.createEngine();
        GasTank gasTank = detailsFactory.createGasTank();
        HeadLights headLights = detailsFactory.createHeadLights();
        Wheel[] wheels = detailsFactory.createWheels(CarWheelRadius.R20);
        Wheel safeWheel = detailsFactory.createSafeWheel(CarWheelRadius.R20);

        return new Hiance(color, 150, TransmissionType.MECHANIC, false, price, gasTank, wheels, engine,
                electrics, headLights, CarWheelRadius.R20, 2000, safeWheel, this.country);
    }

    public Dyna createDyna(String color, double price) {
        Electrics electrics = detailsFactory.createElectrics();
        Engine engine = detailsFactory.createEngine();
        GasTank gasTank = detailsFactory.createGasTank();
        HeadLights headLights = detailsFactory.createHeadLights();
        Wheel[] wheels = detailsFactory.createWheels(CarWheelRadius.R20);
        Socket socket = detailsFactory.createSocket();

        return new Dyna(color, 180, TransmissionType.MECHANIC, false, price, gasTank, wheels, engine,
                electrics, headLights, CarWheelRadius.R20, 3000, socket, this.country);
    }
}
