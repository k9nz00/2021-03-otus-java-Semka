package ru.otus.l12.hw;

import ru.otus.l12.hw.exceptions.NotEnoughMoneyException;
import ru.otus.l12.hw.exceptions.UnavailableAmountException;

import java.util.*;
import java.util.stream.Collectors;

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

    public Map<BanknoteType, Integer> getAmount(int money){
        if (money % 10 != 0){
            throw new UnavailableAmountException();
        }

        if (money > this.getAtmBalance()){
            throw new NotEnoughMoneyException("В банкомате не достаточно денег для выдачи");
        }

        cellList.sort((cell1, cell2) -> cell2.getBanknoteType().compareTo(cell1.getBanknoteType()));
        Map<BanknoteType, Integer> requestedMoney = new HashMap<>();
        int remainsRequestedMoney = money;
        int differenceBalanceAndBills;
        int remains;
            for (CellImpl cell : cellList) {
                remains = remainsRequestedMoney % cell.getBanknoteType().getBanknoteValue();
                differenceBalanceAndBills = remainsRequestedMoney - remains;
                List<BanknoteType> banknoteCount = cell.getBanknotes(differenceBalanceAndBills / cell.getBanknoteType().getBanknoteValue());
                requestedMoney.put(cell.getBanknoteType(), banknoteCount.size());
                remainsRequestedMoney = remainsRequestedMoney - differenceBalanceAndBills;
        }
        return requestedMoney;
    }

}
