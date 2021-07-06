package ru.otus.l12.hw;

import ru.otus.l12.hw.interfaces.Cell;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CellImpl implements Cell {

    private final List<BanknoteType> banknoteStack;

    public BanknoteType getBanknoteType() {
        return banknoteType;
    }

    private final BanknoteType banknoteType;

    public CellImpl(List<BanknoteType> banknoteStack, BanknoteType banknoteType) {
        this.banknoteStack = banknoteStack;
        this.banknoteType = banknoteType;
    }

    public static CellImpl createCell(BanknoteType type, int banknoteCount) {
        List<BanknoteType> banknoteStack = new ArrayList<>();
        for (int i = 0; i < banknoteCount; i++) {
            banknoteStack.add(type);
        }
        return new CellImpl(banknoteStack, type);
    }

    @Override
    public boolean addBanknote(BanknoteType banknote) {
        return banknoteStack.add(banknote);
    }

    /**
     * Проверка на то, что текущая ячейка содержит такие же купюры как и та, что пришла из параметра
     */
    @Override
    public boolean cellContainsBanknotes(BanknoteType banknote) {
        BanknoteType banknoteCurrenCell = banknoteStack.get(0);
        return banknoteCurrenCell.equals(banknote);
    }

    @Override
    public List<BanknoteType> getBanknotes(int countBanknotes) {
        List<BanknoteType> banknotes = new ArrayList<>();
        BanknoteType banknote;
        for (int i = 0; i < countBanknotes; i++) {
            banknote = banknoteStack.remove(i);
            if (banknote != null) {
                banknotes.add(banknote);
            }
        }
        return banknotes;
    }

    @Override
    public int getCellBalance() {
        return banknoteStack.size() * banknoteStack.get(0).getBanknoteValue();
    }
}
