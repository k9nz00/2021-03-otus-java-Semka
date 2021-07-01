package ru.otus.l12.hw.interfaces;


import ru.otus.l12.hw.BanknoteType;

public interface Cell {

    boolean addBanknote(BanknoteType banknoteType);

    boolean cellContainsBanknotes(BanknoteType banknote);
    BanknoteType getBanknote();

    int getCellBalance();
}
