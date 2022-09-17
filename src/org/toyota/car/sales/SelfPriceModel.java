package org.toyota.car.sales;

//        4. Сделать справочник по моделям машин: camry - себестоимость 5000, solara - 8000, hiance - 10000, dyna - 12000
public enum SelfPriceModel {
    CAMRY(5000), SOLARA(8000), HIANCE(10_000), DYNA(12_000);
    private double price;

    SelfPriceModel(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
