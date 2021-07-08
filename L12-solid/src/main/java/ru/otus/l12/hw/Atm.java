package ru.otus.l12.hw;

import java.util.List;
import java.util.Map;

public interface Atm {
    List<Cell> getCellList();

    boolean depositMoney(BanknoteType banknote);

    int getAtmBalance();

    Map<BanknoteType, Integer> getAmount(int money);
}
