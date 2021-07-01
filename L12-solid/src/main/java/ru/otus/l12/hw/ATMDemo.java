package ru.otus.l12.hw;

public class ATMDemo {
    public static void main(String[] args) {

        ATM atm = new ATM();

        atm.depositMoney(BanknoteType.FIFTY);
        atm.depositMoney(BanknoteType.FIFTY);

        atm.depositMoney(BanknoteType.TEN);
        atm.depositMoney(BanknoteType.TEN);
        atm.depositMoney(BanknoteType.TEN);

        atm.depositMoney(BanknoteType.FIVE_THOUSAND);
        atm.depositMoney(BanknoteType.FIVE_THOUSAND);
        atm.depositMoney(BanknoteType.FIVE_THOUSAND);
        atm.depositMoney(BanknoteType.FIVE_THOUSAND);
        atm.depositMoney(BanknoteType.FIVE_THOUSAND);


        atm.depositMoney(BanknoteType.TEN);
        atm.depositMoney(BanknoteType.TEN);
        atm.depositMoney(BanknoteType.TEN);
        atm.depositMoney(BanknoteType.TEN);

        atm.depositMoney(BanknoteType.HUNDRED);
        atm.depositMoney(BanknoteType.HUNDRED);

        atm.depositMoney(BanknoteType.THOUSAND);
        atm.depositMoney(BanknoteType.THOUSAND);
        atm.depositMoney(BanknoteType.THOUSAND);

        atm.depositMoney(BanknoteType.TWO_THOUSAND);
    }
}
