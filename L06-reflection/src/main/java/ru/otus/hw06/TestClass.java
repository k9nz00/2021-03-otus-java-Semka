package ru.otus.hw06;

import ru.otus.hw06.anotations.After;
import ru.otus.hw06.anotations.Before;
import ru.otus.hw06.anotations.Test;

public class TestClass {

    @Before
    public void beforeTest1() {
        System.out.println("Before annotation1 for test");
    }

    @Before
    public void beforeTest2() {
        System.out.println("Before annotation2 for test");
    }

    @After
    public void afterTest1() {
        System.out.println("After annotation1 for test");
    }

    @After
    public void afterTest2() {
        System.out.println("After annotation1 for test");
    }

    @Test
    public void test1()
    {
    }

    @Test
    public void test2()
    {
    }

    @Test
    public void test3()
    {
        throw new RuntimeException("Тест3 с ошибкой");
    }
}
