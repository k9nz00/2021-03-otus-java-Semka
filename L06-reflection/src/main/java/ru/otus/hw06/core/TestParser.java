package ru.otus.hw06.core;

import ru.otus.hw06.anotations.After;
import ru.otus.hw06.anotations.Before;
import ru.otus.hw06.anotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestParser {

    private final Class<?> clazz;
    private final Method[] declaredMethods;

    public TestParser(Class<?> clazz) {
        this.clazz = clazz;
        declaredMethods = clazz.getDeclaredMethods();
    }

    public List<TestCase> parseAnnotations()
    {
        List<Method> beforeMethods = getMethods(Before.class);
        List<Method> testMethods = getMethods(Test.class);
        List<Method> afterMethods = getMethods(After.class);

        List<TestCase> testCases = new ArrayList<>();

        for (Method testMethod: testMethods) {
            TestCase<?> testCase = new TestCase<>(clazz, beforeMethods, testMethod, afterMethods);
            testCases.add(testCase);
        }
        return testCases;
    }

    private List<Method> getMethods(Class<? extends Annotation> annotationNameClass) {
        List<Method> methods = new ArrayList<>();
        for(Method method : declaredMethods) {
            if (method.isAnnotationPresent(annotationNameClass)) {
                methods.add(method);
            }
        }
        return methods;
    }
}
