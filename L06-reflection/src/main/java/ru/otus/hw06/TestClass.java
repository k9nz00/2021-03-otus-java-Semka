package ru.otus.hw06;

import ru.otus.hw06.framework.anotations.After;
import ru.otus.hw06.framework.anotations.Before;
import ru.otus.hw06.framework.anotations.Test;

public class TestClass {

    @Before
    public void beforeTest() {
        System.out.println("Before test method1");
    }

    @Before
    public void beforeTest2() {
        System.out.println("Before test method2");
    }

    @Test
    public void test1()
    {
        System.out.println("Test1 method, must be passed");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("Test2 method, must be failed");
        throw new RuntimeException("Fail test2 method");
    }

    @Test
    public void test3()
    {
        System.out.println("Test3 method, must be passed");
    }

    @After
    public void afterTest1() {
        System.out.println("After test method1");
    }

    @After
    public void afterTest2() {
        System.out.println("After test method2");
    }

}
