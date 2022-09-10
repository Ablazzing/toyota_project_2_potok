package org.toyota.car.sales;

public enum ModelPrice {
    CAMRY(10000),
    SOLARA(12000),
    HIANCE(15000),
    DYNA(22000);
    private double price;

    ModelPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
