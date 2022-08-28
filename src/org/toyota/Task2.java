package org.toyota;

import org.toyota.car.factory.AssemblyCar;
import org.toyota.car.factory.Country;
import org.toyota.car.factory.CountyFactoryNotEqualException;
import org.toyota.car.factory.DetailsFactory;
import org.toyota.car.models.Camry;

public class Task2 {
    public static void main(String[] args) {
//        Задание №2
//        Мы с вами создали машины, их детали, описали действия. Но создавать машины сейчас крайне неудобно:
//        нам приходиться самим создавать детали, передавать их в конструктор.
//        А ведь менеджеру нужно только установить цену машины и ее цвет!
//        Необходимо:
//        1. Реализовать фабрику производств деталей - класс, в котором будут методы создающие все наши детали
//        в работоспособном состоянии, (бензобак должен быть пустой).
//        У завода должнен быть атрибут - страна (ведь заводов может быть много).
//        Подумать, какой тип данных у атрибута Страна.
//        2. Реализовать сборочный конвеер - класс, который будет использовать фабрику производств и отдавать
//        нам готовые машины. Например должен быть метод, который принимает в себя два параметра - цвет и цену,
//        а возвращает новую Camry. Необходимо создать 4 метода, которые будут создавать все наши модели:
//        createCamry, createSolara, createHiance, createDyna. Сборочный конвеер может пользоваться только той фабрикой производств,
//        которая находится в той же стране (Подумать где должна происходить эта проверка).
//        Иначе должна появляться ошибка: CountyFactoryNotEqualException - в описании ошибки должны описаться страны которые не совпали.
//    }

        DetailsFactory detailsFactory;
        AssemblyCar assemblyCar;
        try {
            detailsFactory = new DetailsFactory(Country.RUSSIA);
            assemblyCar = new AssemblyCar(Country.USA, detailsFactory);
            Camry camry = assemblyCar.createCamry("black", 10_000);
            camry.refuel(20);
            camry.onMusic();
        } catch (CountyFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Программа работает дальше!");
    }
}
