package ru.otus.l12.hw;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ATM {

    List<CellImpl> cellList = new ArrayList<>();

    public ATM() {
        Arrays.stream(BanknoteType.values())
                .forEach(banknoteType -> {
                    ArrayDeque<BanknoteType> banknoteStack = new ArrayDeque<>();
                    for (int i = 0; i < 10; i++) {
                        banknoteStack.add(banknoteType);
                    }
                    cellList.add(new CellImpl(banknoteStack, banknoteType));
                });
    }

    public boolean depositMoney(BanknoteType banknote) {
        boolean result = false;
        for (CellImpl cell : cellList) {
            if (cell.cellContainsBanknotes(banknote)) {
                result = cell.addBanknote(banknote);
            }
        }
        return result;
    }

    public int getAtmBalance() {
        int balance = 0;
        for (CellImpl cell : cellList) {
            balance += cell.getCellBalance();
        }
        return balance;
    }

}
