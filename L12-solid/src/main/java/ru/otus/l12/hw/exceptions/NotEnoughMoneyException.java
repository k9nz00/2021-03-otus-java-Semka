package ru.otus.l12.hw.exceptions;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String error) {
        super(error);
    }
}
