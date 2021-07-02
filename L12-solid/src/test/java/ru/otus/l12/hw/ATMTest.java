package ru.otus.l12.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.l12.hw.exceptions.NotEnoughMoneyException;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

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

    @Test
    @DisplayName("Попытка снять 1560")
    void getAmount1500() {
        Map<BanknoteType, Integer> amount = atm.getAmount(1560);
        System.out.print("купюры при снятии 1560 монет: ");
        System.out.println(amount);
        assertThat(amount)
                .isNotNull();
    }

    @Test
    @DisplayName("Попытка снять 25000")
    void getAmount25000() {
        Map<BanknoteType, Integer> amount = atm.getAmount(25000);
        System.out.print("купюры при снятии 25000 монет: ");
        System.out.println(amount);
        assertThat(amount)
                .isNotNull();
    }

    @Test
    @DisplayName("Попытка снять 1000_000. Ожидается ошибка из-за недостатка средств в банкомате")
    void getAmount1000_000() {

        try {
            Map<BanknoteType, Integer> amount = atm.getAmount(1000_000);
        } catch (NotEnoughMoneyException e){
            assertThat(e).hasMessage("В банкомате не достаточно денег для выдачи");
        }
    }



}