package ru.otus.hw06.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class TestCase {
    private final Constructor<?> clazz;
    private final List<Method> beforeMethods;
    private final List<Method> afterMethods;
    private final Method testMethod;

    TestCase(
            Constructor<?> clazz,
            List<Method> beforeMethods,
            Method TestMethod,
            List<Method> afterMethods
    ) {
        this.clazz = clazz;
        this.beforeMethods = beforeMethods;
        this.afterMethods = afterMethods;
        testMethod = TestMethod;
    }

    public Constructor<?> getClassConstructor() {
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
