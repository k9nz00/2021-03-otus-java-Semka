package ru.otus.l12.hw;

import java.util.Map;

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

//        atm.getAmount(155);
        Map<BanknoteType, Integer> amount1 = atm.getAmount(12270);
        Map<BanknoteType, Integer> amount2 = atm.getAmount(5000);
        Map<BanknoteType, Integer> amount3 = atm.getAmount(25010);
        Map<BanknoteType, Integer> amount4 = atm.getAmount(3550);

        int a = 10;
    }
}
