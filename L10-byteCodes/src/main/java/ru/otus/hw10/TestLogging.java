package ru.otus.hw10;

import ru.otus.hw10.annotations.Log;

public class TestLogging implements TestLoggingInterface{

    @Log
    @Override
    public void calculation(int param) {

    }

    @Log
    @Override
    public void calculation(int param1, int param2) {

    }

    @Log
    @Override
    public void calculation(int param1, int param2, String string1) {

    }

    @Override
    public void calculation(String string1, String string2) {

    }
}
