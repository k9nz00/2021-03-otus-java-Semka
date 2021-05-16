package ru.otus.hw06;

import ru.otus.hw06.anotations.After;
import ru.otus.hw06.anotations.Before;
import ru.otus.hw06.anotations.Test;

public class TestClass {

    @Before
    public void beforeTest1() {
        System.out.println("Before test method1");
    }

    @Before
    public void beforeTest2() {
        System.out.println("Before test method2");
    }

    @After
    public void afterTest1() {
        System.out.println("After test method1");
    }

    @After
    public void afterTest2() {
        System.out.println("After test method2");
    }

    @Test
    public void test1()
    {
        System.out.println("Test method1, must be passed");
    }

    @Test
    public void test2()
    {
        System.out.println("Test method2, must be passed");
    }

    @Test
    public void test3()
    {
        System.out.println("Test method3, must be failed");
    }


}
