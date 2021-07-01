package ru.otus.l12.hw;

import ru.otus.l12.hw.exceptions.NotEnoughMoneyException;
import ru.otus.l12.hw.interfaces.Cell;

import java.util.ArrayDeque;

public class CellImpl implements Cell {

    private final ArrayDeque<BanknoteType> banknoteStack;
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
        if (banknoteCurrenCell.equals(banknote)){
            result = true;
        }
        return result;
    }

    @Override
    public BanknoteType getBanknote() {
        BanknoteType banknoteType = banknoteStack.pollFirst();
        if (banknoteType == null) {
            throw new NotEnoughMoneyException("Денег нет, но вы держитесь");
        }
        return banknoteType;
    }

    @Override
    public int getCellBalance() {
        return banknoteStack.size() *  banknoteStack.peek().getBanknoteValue();
    }
}
