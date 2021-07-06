package ru.otus.l12.hw;

import ru.otus.l12.hw.interfaces.Cell;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CellImpl implements Cell {

    private final Deque<BanknoteType> banknoteStack;

    public BanknoteType getBanknoteType() {
        return banknoteType;
    }

    private final BanknoteType banknoteType;

    public CellImpl(Deque<BanknoteType> banknoteStack, BanknoteType banknoteType) {
        this.banknoteStack = banknoteStack;
        this.banknoteType = banknoteType;
    }

    public static CellImpl createCell(BanknoteType type, int banknoteCount) {
        ArrayDeque<BanknoteType> banknoteStack = new ArrayDeque<>();
        for (int i = 0; i < banknoteCount; i++) {
            banknoteStack.add(type);
        }
        return new CellImpl(banknoteStack, type);
    }

    @Override
    public boolean addBanknote(BanknoteType banknote) {
        return banknoteStack.offerLast(banknote);
    }

    @Override
    /**
     * Проверка на то, что текущая ячейка содержит такие же купюры как и та, что пришла из параметра
     */
    public boolean cellContainsBanknotes(BanknoteType banknote) {
        BanknoteType banknoteCurrenCell = banknoteStack.peek();
        return banknoteCurrenCell.equals(banknote);
    }

    @Override
    public List<BanknoteType> getBanknotes(int countBanknotes) {
        List<BanknoteType> banknotes = new ArrayList<>();
        BanknoteType banknote;
        for (int i = 0; i < countBanknotes; i++) {
            banknote = banknoteStack.pollLast();
            if (banknote != null) {
                banknotes.add(banknote);
            }
        }
        return banknotes;
    }

    @Override
    public int getCellBalance() {
        return banknoteStack.size() * banknoteStack.peek().getBanknoteValue();
    }
}
