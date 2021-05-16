package ru.otus.hw06.core;

import java.lang.reflect.Method;
import java.util.List;


public class TestCase<T> {
    private final Class<T> clazz;
    private final List<Method> beforeMethods;
    private final List<Method> afterMethods;
    private final Method testMethod;

    TestCase(
            Class<T> clazz,
            List<Method> beforeMethods,
            Method TestMethod,
            List<Method> afterMethods
    ) {
        this.clazz = clazz;
        this.beforeMethods = beforeMethods;
        this.afterMethods = afterMethods;
        testMethod = TestMethod;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public List<Method> getBeforeMethods() {
        return beforeMethods;
    }

    public List<Method> getAfterMethods() {
        return afterMethods;
    }

    public Method getTestMethod() {
        return testMethod;
    }
}
