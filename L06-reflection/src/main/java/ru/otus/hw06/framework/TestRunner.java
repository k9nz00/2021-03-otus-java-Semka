package ru.otus.hw06.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class TestRunner {
    private final String className;

    public TestRunner(String className) {
        this.className = className;
    }

    public void run() throws Exception {

            Class<?> clazz = Class.forName(className);

            TestParser testParser = new TestParser(clazz);
            TestsProgress testsProgress = new TestsProgress();

            List<TestCase> testCases = testParser.parseAnnotations();

            for (TestCase testCase : testCases) {
                runCase(testCase, testsProgress);
            }

            testsProgress.createTestStatistic();
            testsProgress.printTestsStatistic();
    }

    private void runCase(TestCase testCase, TestsProgress testsProgress) throws Exception {

        Constructor<?> constructor = testCase.getClassConstructor();
        Method testMethod = testCase.getTestMethod();
        List<Method> afterMethods = testCase.getAfterMethods();
        List<Method> beforeMethods = testCase.getBeforeMethods();
        Object classInstance = constructor.newInstance();

        try {
            testsProgress.addTotalCount();
            if (beforeMethods != null) {
                for (Method beforeMethod : beforeMethods) {
                    beforeMethod.invoke(classInstance);
                }
            }

            testMethod.invoke(classInstance);

            testsProgress.addPassedTestCount();
            System.out.println("Тест " + testMethod.getName() + " выполнен успешно!");
        } catch (Exception e) {
            testsProgress.addFailedTestsCount();
            System.out.println("Ошибка теста: " + testMethod.getName());
        }
        finally {
            if (afterMethods != null) {
                for (Method afterMethod : afterMethods) {
                    afterMethod.invoke(classInstance);
                }
            }
            System.out.println();
        }
    }
}
