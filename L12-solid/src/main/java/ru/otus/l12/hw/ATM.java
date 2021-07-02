package ru.otus.l12.hw;

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

        cellList.sort((cell1, cell2) -> cell2.getBanknoteType().compareTo(cell1.getBanknoteType()));


        Map<BanknoteType, Integer> requestedMoney = new HashMap<>();
        List<BanknoteType> banknotes = Arrays.asList(BanknoteType.values());
        banknotes.sort(Comparator.reverseOrder());

        int remainsRequestedMoney = money;
        int differenceBalanceAndBills;
        int remains;

        //  если к концу всего цикла в банкомате закончились банкноты, а нужная сумма еще не набралась (remainsRequestedMoney > 0),
        //  то в таком случае выбрасывать исключение о нехватке денег в банкомате
        //while  перенести внутрь for, что бы в ситуации когда remainsRequestedMoney == 0 не было не нужных проходов по циклу
            for (BanknoteType banknote : banknotes) {
                remains = remainsRequestedMoney % banknote.getBanknoteValue();
                differenceBalanceAndBills = remainsRequestedMoney - remains;


                requestedMoney.put(banknote, differenceBalanceAndBills / banknote.getBanknoteValue());

                remainsRequestedMoney = remainsRequestedMoney - differenceBalanceAndBills;
        }
        return requestedMoney;
    }

}
