package ru.otus.l12.hw;

public enum BanknoteType {
    TEN(10),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000),
    TWO_THOUSAND(2000),
    FIVE_THOUSAND(5000);

    private int banknoteValue;

    BanknoteType(int banknoteValue) {
        this.banknoteValue = banknoteValue;
    }

    public int getBanknoteValue() {
        return banknoteValue;
    }
}
