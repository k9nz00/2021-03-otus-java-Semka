package ru.otus.hw10;

import ru.otus.hw10.annotations.Log;

public class TestLogging implements TestLoggingInterface{

    @Log
    public void calculation(int param) {

    }

    @Override
    public void calculation(int param1, int param2) {

    }

    @Override
    public void calculation(int param1, int param2, String string1) {

    }
}
