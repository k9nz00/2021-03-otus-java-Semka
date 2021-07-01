package ru.otus.l12.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ATMTest {
    ATM atm = new ATM();

    @Test
    @DisplayName("Внесмение купюры на 10 попугаев")
    void depositMoneyTen() {
        boolean success = atm.depositMoney(BanknoteType.TEN);
        Assertions.assertTrue(success);
    }

    @Test
    @DisplayName("Внесмение купюры на 50 попугаев")
    void depositMoneyFifty() {
        boolean success = atm.depositMoney(BanknoteType.FIFTY);
        Assertions.assertTrue(success);
    }

    @Test
    @DisplayName("Внесмение купюры на 100 попугаев")
    void depositMoneyHundred() {
        boolean success = atm.depositMoney(BanknoteType.HUNDRED);
        Assertions.assertTrue(success);
    }

    @Test
    @DisplayName("Внесмение купюры на 500 попугаев")
    void depositMoneyFiveHundred() {
        boolean success = atm.depositMoney(BanknoteType.FIVE_HUNDRED);
        Assertions.assertTrue(success);
    }

    @Test
    @DisplayName("Внесмение купюры на 1000 попугаев")
    void depositMoneyThousand() {
        boolean success = atm.depositMoney(BanknoteType.THOUSAND);
        Assertions.assertTrue(success);
    }

    @Test
    @DisplayName("Внесмение купюры на 2000 попугаев")
    void depositMoneyTwoThousand() {
        boolean success = atm.depositMoney(BanknoteType.TWO_THOUSAND);
        Assertions.assertTrue(success);
    }

    @Test
    @DisplayName("Внесмение купюры на 5000 попугаев")
    void depositMoneyFiveThousand() {
        boolean success = atm.depositMoney(BanknoteType.FIVE_THOUSAND);
        Assertions.assertTrue(success);
    }

    @Test
    @DisplayName("Баланс банкомата должен быть больше нуля")
    void getAtmBalance() {
        System.out.println(atm.getAtmBalance());
        Assertions
                .assertTrue(atm.getAtmBalance() > 0);
    }
}