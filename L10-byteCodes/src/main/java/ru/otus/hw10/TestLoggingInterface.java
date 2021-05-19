package ru.otus.hw10;

import ru.otus.hw10.annotations.Log;

public interface TestLoggingInterface {

    @Log
    public void calculation(int param1);

    @Log
    public void calculation(int param1, int param2);

    @Log
    public void calculation(int param1, int param2, String string1);
}
