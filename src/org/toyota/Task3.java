package org.toyota;

import org.toyota.car.factory.AssemblyCar;
import org.toyota.car.factory.Country;
import org.toyota.car.factory.CountyFactoryNotEqualException;
import org.toyota.car.factory.DetailsFactory;
import org.toyota.car.models.Camry;
import org.toyota.car.storage.CarNotExistException;
import org.toyota.car.storage.CarStorage;

public class Task3 {
    public static void main(String[] args) {
//        Задание №3
//        Мы с вами продвинулись в создании машин, но машины должны где то храниться!
//                Для этого нам потребуется создать склад машин.
//                Каждый склад может хранить в себе до 1000 машин разных типов.
//                Поэтому необходимо:
//        1. Создать новый класс склад. Который имеет количество машин при создании - 0.
//        2. Создать в нем переменные, которые будут отвечать за хранение конкретного типа машин.
//        3. Создать методы добавления машин по каждому типу в переменные из шага два.
//        При добавлении машины, свободное место на складе должно уменьшаться.
//        4. Создать методы взятия машин со склада: общий счетчик уменьшается на 1,
//        а в переменной ответственной за хранение машины определенной модели должна быть удалена конкретная машина.
//        Методы возвращают экземпляр модели.
//        5. Написать методы, которые будут показывать количество машин по каждой модели.
//        6. Расширить абстрактный класс Car, добавив атрибут Country (страна сборки).
//        При сборке машины указать ее страну.
//        Внимание! Запрещено использовать arrayList. Только массивы

//        int[] numbers = {1, 2};
//        int i = 1;
//        System.out.println(numbers[i--]);
//        System.out.println(i);
//
//        if (i++ > 0) {
//            System.out.println("Больше нуля");
//        }
//        System.out.println(i);

//        Object[] cars = {1, null};
//        int size = 1;
//        System.out.println(cars[--size]);

//        int x = 0;
//        System.out.println(x++);
//        System.out.println(x);
//
//        int x2 = 0;
//        System.out.println(++x2);
//        System.out.println(x2);
        try {
            DetailsFactory detailsFactory = new DetailsFactory(Country.RUSSIA);
            AssemblyCar assemblyCar = new AssemblyCar(Country.RUSSIA, detailsFactory);
            Camry camry = assemblyCar.createCamry("black", 10_000);
            CarStorage carStorage = new CarStorage();
            carStorage.addCamry(camry);
            Camry camry1 = carStorage.getCamry();
        } catch (CountyFactoryNotEqualException | CarNotExistException e) {
            System.out.println(e.getMessage());
        }
    }
}
