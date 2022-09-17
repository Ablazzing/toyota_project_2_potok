package org.toyota;


import org.toyota.car.cartype.Car;
import org.toyota.car.factory.AssemblyCar;
import org.toyota.car.factory.Country;
import org.toyota.car.factory.CountyFactoryNotEqualException;
import org.toyota.car.factory.DetailsFactory;
import org.toyota.car.models.Camry;
import org.toyota.car.sales.Customer;
import org.toyota.car.sales.CustomerHasNoMoneyException;
import org.toyota.car.sales.Manager;
import org.toyota.car.sales.ManagerReportHelper;
import org.toyota.car.storage.CarStorage;

import java.io.IOException;

public class Task5 {
    public static void main(String[] args) throws CountyFactoryNotEqualException, CustomerHasNoMoneyException, IOException {
//        У нас уже есть все для старта продаж, но как мы поймем сколько машин мы продали, какую прибыль получили?
//        Нам необходима статистика продаж!
//        Необходимо:
//        1. Дать менеджеру имя.
//        2. Создать класс Report, в котором будет отображаться вся статистика менеджера: имя менеджера,
//        проданные машины.
//        3. Во время продажи, менеджер должен обновить свой report - добавить проданную машину в список.
//        4. Сделать справочник по моделям машин: camry - себестоимость 5000, solara - 8000, hiance - 10000, dyna - 12000
//        5. У менеджера должен появиться метод: сгенерируй отчет, в котором он выводит информацию в файл txt формата:
//        Имя менеджера
//        Модель №1 - стоимость продажи - себестоимость
//        Модель №2 - стоимость продажи - себестоимость
//        ....
//        Итог: доходы - (сумма всех продаж), расходы (сумма всех себестоимостей), прибыль - (доходы - расходы)
        DetailsFactory detailsFactory = new DetailsFactory(Country.RUSSIA);
        AssemblyCar assemblyCar = new AssemblyCar(Country.RUSSIA, detailsFactory);
        CarStorage carStorage = new CarStorage();

        Manager petr = new Manager("Petr", carStorage, assemblyCar);
        Customer customer1 = new Customer("Yuri", 12000);
        Customer customer2 = new Customer("Yuri", 30000);
        Car car = petr.saleCar(customer1);
        Car car1 = petr.saleCar(customer2);
        ManagerReportHelper.generateReport(petr, "E:\\repos\\toyota_project_2_potok\\report.txt");

    }
}
