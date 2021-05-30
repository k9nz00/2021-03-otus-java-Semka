package ru.otus.hw10;

public class TestLoggingDemo {
    public static void main(String[] args) {

        TestLoggingInterface testLoggingClass = IocDemo.createTestLoggingClass();
        testLoggingClass.calculation(10);
        testLoggingClass.calculation(10, 20);
        testLoggingClass.calculation(10, 20, "Hello!");
    }
}
