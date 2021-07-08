package ru.otus.l12.hw.exceptions;

public class UnavailableAmountException extends IllegalArgumentException {
    public UnavailableAmountException(String error) {
        super(error);
    }
}
