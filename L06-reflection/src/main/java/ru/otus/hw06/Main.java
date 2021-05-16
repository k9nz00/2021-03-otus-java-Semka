package ru.otus.hw06;

import ru.otus.hw06.core.TestRunner;

public class Main {
    public static void main(String[] args) throws Exception {
//        if (args.length > 0) {
//            TestRunner testRunner = new TestRunner(args[0]);
            TestRunner testRunner = new TestRunner("ru.otus.hw06.TestClass");
            testRunner.run();
//        } else {
//            throw new RuntimeException("Class name is required!");
//        }
    }
}