package ru.otus.l12.hw;

import ru.otus.l12.hw.exceptions.NotEnoughMoneyException;
import ru.otus.l12.hw.exceptions.UnavailableAmountException;
import ru.otus.l12.hw.interfaces.Cell;

import java.util.*;

public class AtmImpl implements ru.otus.l12.hw.interfaces.Atm {

    private final List<Cell> cellList;

    @Override
    public List<Cell> getCellList() {
        return cellList;
    }

    //дефолтный конструктор банкомата, в котором в каждой ячейке лежит по 10 купюр каждого номинала
    public AtmImpl() {
        cellList = new ArrayList<>();
        Arrays.stream(BanknoteType.values())
                .forEach(banknoteType -> {
                    List<BanknoteType> banknoteStack = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        banknoteStack.add(banknoteType);
                    }
                    cellList.add(new CellImpl(banknoteStack, banknoteType));
                });
    }

    public AtmImpl(List<Cell> cellList) {
        this.cellList = cellList;
    }

    //Предполагается, что банкноты вносятся в ячейки(кассеты) по одной
    @Override
    public boolean depositMoney(BanknoteType banknote) {
        boolean result = false;
        for (Cell cell : getCellList()) {
            if (cell.cellContainsBanknotes(banknote)) {
                result = cell.addBanknote(banknote);
            }
        }

        if (!result && Arrays.asList(BanknoteType.values()).contains(banknote)) {
            Cell cell = CellImpl.createCell(banknote, 1);
            result = this.cellList.add(cell);
        }

        return result;
    }

    @Override
    public int getAtmBalance() {
        int balance = 0;
        for (Cell cell : getCellList()) {
            balance += cell.getCellBalance();
        }
        return balance;
    }

    @Override
    public Map<BanknoteType, Integer> getAmount(int money) {
        //В банкомате могут быть только купюры кратные 10. Монеты не поддерживаются
        if (money % 10 != 0) {
            throw new UnavailableAmountException("Неподерживаемая сумма для выдачи. Запрошенная сумма должна быть кратна 10");
        }

        //проверка на невозможность снять денег больше, чем находится в банкомате
        if (money > this.getAtmBalance()) {
            throw new NotEnoughMoneyException("В банкомате не достаточно денег для выдачи");
        }

        cellList.sort((cell1, cell2) -> cell2.getBanknoteType().compareTo(cell1.getBanknoteType()));
        Map<BanknoteType, Integer> requestedMoney = new HashMap<>();
        int remainsRequestedMoney = money;
        int differenceBalanceAndBills;
        int remains;
        for (Cell cell : getCellList()) {
            remains = remainsRequestedMoney % cell.getBanknoteType().getBanknoteValue();
            differenceBalanceAndBills = remainsRequestedMoney - remains;
            List<BanknoteType> banknoteCount = cell.getBanknotes(differenceBalanceAndBills / cell.getBanknoteType().getBanknoteValue());
            requestedMoney.put(cell.getBanknoteType(), banknoteCount.size());
            remainsRequestedMoney = remainsRequestedMoney - differenceBalanceAndBills;
        }
        return requestedMoney;
    }
}
