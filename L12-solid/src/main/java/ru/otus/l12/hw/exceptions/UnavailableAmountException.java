package ru.otus.l12.hw.exceptions;

public class UnavailableAmountException extends IllegalArgumentException{
    public UnavailableAmountException() {
        super("Неподерживаемая сумма для выдачи. Запрошенная сумма должна быть кратна 10");
    }
}
