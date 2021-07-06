package ru.otus.l12.hw.interfaces;

import ru.otus.l12.hw.BanknoteType;

import java.util.List;
import java.util.Map;

public interface Atm {
    List<Cell> getCellList();

    boolean depositMoney(BanknoteType banknote);

    int getAtmBalance();

    Map<BanknoteType, Integer> getAmount(int money);
}
