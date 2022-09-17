package org.toyota.car.sales;

//        5. У менеджера должен появиться метод: сгенерируй отчет, в котором он выводит информацию в файл txt формата:
//        Имя менеджера
//        Модель №1 - стоимость продажи - себестоимость
//        Модель №2 - стоимость продажи - себестоимость
//        ....
//        Итог: доходы - (сумма всех продаж), расходы (сумма всех себестоимостей), прибыль - (доходы - расходы)

import org.toyota.car.cartype.Car;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManagerReportHelper {

    public static void generateReport(Manager manager, String path) throws IOException {
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        double allIncome = 0;
        double allOutcome = 0;
        for (Car car : manager.getReport().getCars()) {
            SelfPriceModel selfPriceModel = SelfPriceModel.valueOf(car.getClass().getSimpleName().toUpperCase());
            allIncome += car.getPrice();
            allOutcome += selfPriceModel.getPrice();
            String result = new StringBuilder()
                    .append(car.getClass().getSimpleName())
                    .append(" - ")
                    .append(car.getPrice())
                    .append(" - ")
                    .append(selfPriceModel.getPrice())
                    .toString();
            writer.write(result);
            writer.newLine();
        }
//        Итог: доходы - (сумма всех продаж), расходы (сумма всех себестоимостей), прибыль - (доходы - расходы)
        String allResult = new StringBuilder()
                .append("Итог: доходы - ")
                .append(allIncome)
                .append(", расходы - ")
                .append(allOutcome)
                .append(", прибыль - ")
                .append(allIncome - allOutcome)
                .toString();
        writer.write(allResult);
        writer.close();
    }
}
