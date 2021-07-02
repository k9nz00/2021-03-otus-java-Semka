package ru.otus.l12.hw;

import ru.otus.l12.hw.interfaces.Cell;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CellImpl implements Cell{

    private final ArrayDeque<BanknoteType> banknoteStack;

    public BanknoteType getBanknoteType() {
        return banknoteType;
    }

    private final BanknoteType banknoteType;

    public CellImpl(ArrayDeque<BanknoteType> banknoteStack, BanknoteType banknoteType) {
        this.banknoteStack = banknoteStack;
        this.banknoteType = banknoteType;
    }

    @Override
    public boolean addBanknote(BanknoteType banknote) {
        return banknoteStack.offerLast(banknote);
    }

    @Override
    public boolean cellContainsBanknotes(BanknoteType banknote) {
        boolean result = false;
        BanknoteType banknoteCurrenCell = banknoteStack.peek();
        assert banknoteCurrenCell != null;
        if (banknoteCurrenCell.equals(banknote)) {
            result = true;
        }
        return result;
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
