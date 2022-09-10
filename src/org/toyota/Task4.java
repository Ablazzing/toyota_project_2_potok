package org.toyota;

import org.toyota.car.StartCarException;
import org.toyota.car.cartype.Car;
import org.toyota.car.factory.AssemblyCar;
import org.toyota.car.factory.Country;
import org.toyota.car.factory.CountyFactoryNotEqualException;
import org.toyota.car.factory.DetailsFactory;
import org.toyota.car.models.Camry;
import org.toyota.car.models.Dyna;
import org.toyota.car.models.Hiance;
import org.toyota.car.models.Solara;
import org.toyota.car.sales.*;
import org.toyota.car.storage.CarStorage;

public class Task4 {
    //    Задача №4
    //    У нас уже есть машины, которые могут храниться на складах!
    //    Теперь нам необходимо создать дилерскую сеть, которая будет продавать машины!
    //    Для этого нам потребуется:
    //    Создать склад, производство и сборку в Японии.
    //    1. Создать 4 модели машины: camry 10000 black, solara 12000 white, hiance 15000 black, dyna 22000 black.
    //    2. Занести их в склад.
    //    3. Создать покупателя, у которого мы задаем сумму денег, на которую он может купить машину, а так же его имя
    //    4. Создать Менеджера: он ожидает нового покупателя, и за его сумму предлагает купить машину.
    //    У менеджера есть метод - продать машину клиенту: возвращается самая дорогая машина,
    //    которую может купить покупатель со своей суммой денег из имеющихся. Если машин на складе нет, то
    //    идет запрос на сборку и производство по ценам из пункта №1, и машина заносится на склад.
    //    Если клиенту не хватает денег, то никакую машину он не получает.
    //    5. Создать кассира: кассир принимает заказ - берет машину, и заносит в общий для всех кассиров счет доходов.
    //

    //
    //    Процесс продажи:
    //    Создается менеджер
    //    Создается покупатель №1
    //    Менеджер принимает покупателя №1 и возвращает машину
    //    Кассир принимает машину для продажи и заносит в счет проданную машину
    //        ...
    //    Создается покупатель №2 и начинается снова продажа машин
    //    В конце выводится сумма проданных машин

    public static void main(String[] args) throws CountyFactoryNotEqualException {
        CarStorage carStorage = new CarStorage();
        DetailsFactory detailsFactory = new DetailsFactory(Country.JAPAN);
        AssemblyCar assemblyCar = new AssemblyCar(Country.JAPAN, detailsFactory);

        Camry camry = assemblyCar.createCamry("black", ModelPrice.CAMRY.getPrice());
        Solara solara = assemblyCar.createSolara("white", ModelPrice.SOLARA.getPrice());
        Hiance hiance = assemblyCar.createHiance("black", ModelPrice.HIANCE.getPrice());
        Dyna dyna = assemblyCar.createDyna("black", ModelPrice.DYNA.getPrice());
        carStorage.addCamry(camry);
        carStorage.addSolara(solara);
        carStorage.addDyna(dyna);
        carStorage.addHiance(hiance);


        Manager manager = new Manager(carStorage, assemblyCar);
        Customer[] customers = {
                new Customer("Petr", 10000),
                new Customer("Petr", 12000),
                new Customer("Petr", 15000),
                new Customer("Petr", 22000),
                new Customer("Petr", 11000),
                new Customer("Petr", 13000),
                new Customer("Yuri", 8000),
                new Customer("Petr", 30000),
        };

        Casher casher = new Casher();
        for (Customer customer : customers) {
            try {
                Car car = manager.saleCar(customer);
                casher.saleCar(car);
            } catch (CustomerHasNoMoneyException e) {
                System.out.println(e.getMessage());
            }
        }

        Casher.getIncomes();
    }
}
