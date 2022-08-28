package org.toyota.car.cartype;

import org.toyota.car.StartCarException;
import org.toyota.car.details.*;

public abstract class Car {
    private String color;
    private int maxSpeed;
    private TransmissionType transmissionType;
    private boolean isMove;
    private double price;
    private GasTank gasTank;
    private Wheel[] wheels;
    private Engine engine;
    private Electrics electrics;
    private HeadLights headLights;
    private CarWheelRadius carWheelRadius;

    public Car(String color, int maxSpeed, TransmissionType transmissionType, boolean isMove, double price,
               GasTank gasTank, Wheel[] wheels, Engine engine, Electrics electrics, HeadLights headLights,
               CarWheelRadius carWheelRadius) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmissionType = transmissionType;
        this.isMove = isMove;
        this.price = price;
        this.gasTank = gasTank;
        this.wheels = wheels;
        this.engine = engine;
        this.electrics = electrics;
        this.headLights = headLights;
        this.carWheelRadius = carWheelRadius;
        for (Wheel wheel : wheels) {
            if (wheel.getWheelRadius() != carWheelRadius) {
                throw new RuntimeException("Радиус передаваемых колес должен быть " + wheel.getWheelRadius());
            }
        }
    }

    //Начать движение - меняет состояние движения. Начать движение возможно только при: наличии всех колес
    //и они не проколоты, непустом бензобаке, работоспособным электрике и двигателю.
    //Если что то из этого невыполняется, то выкидывается ошибка StartCarException,
    //в сообщении которой содержится причина невозможности движения.
    public void start() throws StartCarException {
        if (checkWheels() && gasTank.getVolume() > 0 && !electrics.isBroken() && !engine.isBroken()) {
            this.isMove = true;
            System.out.println("Машина начала движение");
        }
        if (!checkWheels()) {
            throw new StartCarException("У машины проблема с колесами");
        }
        if (gasTank.getVolume() <= 0) {
            throw new StartCarException("У машины нет бензина");
        }
        if (electrics.isBroken()) {
            throw new StartCarException("У машины сломана электрика");
        }
        if (engine.isBroken()) {
            throw new StartCarException("У машины сломан двигатель");
        }
    }

    public boolean checkWheels() {
        if (wheels.length == 4) {
            boolean wheelsIsOk = true;
            for (Wheel wheel : wheels) {
                if (wheel.isBroken()) {
                    wheelsIsOk = false;
                    break;
                }
            }
            return wheelsIsOk;
        } else {
            return false;
        }
    }

    //Остановить движение - меняет состояние движения. Для остановки не нужно условий.
    public void stop() {
        this.isMove = false;
        System.out.println("Машина остановилась");
    }

    //Включить фары - сообщает о работе фар.
    public void headlightsOn() {
        if (!headLights.isBroken()) {
            System.out.println("Включаем фары");
        }
    }

    public void switchWheel(int index, Wheel wheel) {
        if (wheel.getWheelRadius() == carWheelRadius) {
            wheels[index] = wheel;
        }
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void refuel(int volume) {
        this.gasTank.setVolume(this.gasTank.getVolume() + volume);
    }
}
