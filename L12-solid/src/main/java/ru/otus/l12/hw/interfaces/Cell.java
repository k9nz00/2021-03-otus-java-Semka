package ru.otus.l12.hw.interfaces;


import ru.otus.l12.hw.BanknoteType;

import java.util.List;

public interface Cell {
    boolean addBanknote(BanknoteType banknoteType);

    boolean cellContainsBanknotes(BanknoteType banknote);

    List<BanknoteType> getBanknotes(int countBanknotes);

    int getCellBalance();

    BanknoteType getBanknoteType();
}
