package ru.otus.hw06;

import ru.otus.hw06.framework.TestRunner;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
        TestRunner.run(args[0]);
        } else {
            throw new RuntimeException("Class name is required!");
        }
    }
}