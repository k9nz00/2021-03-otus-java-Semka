package ru.otus.l12.hw;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AtmDemo {
    public static void main(String[] args) {

        List<CellImpl> cellList = new ArrayList<>();
        cellList.add(CellImpl.createCell(BanknoteType.TEN, 1000));
        cellList.add(CellImpl.createCell(BanknoteType.FIFTY, 50));
        cellList.add(CellImpl.createCell(BanknoteType.HUNDRED, 89));
        cellList.add(CellImpl.createCell(BanknoteType.FIVE_HUNDRED, 78));
        cellList.add(CellImpl.createCell(BanknoteType.THOUSAND, 19));
        cellList.add(CellImpl.createCell(BanknoteType.TWO_THOUSAND, 85));
        cellList.add(CellImpl.createCell(BanknoteType.FIVE_HUNDRED, 50));
        ATM atm = new ATM(cellList);
    }
}
