package ru.otus.hw06.core;

public class TestsProgress {

    private int totalTestCount = 0;
    private int passedTestCount = 0;
    private int failedTestsCount = 0;
    private String testResultInfo;

    public void createTestStatistic() {
        testResultInfo =
                "Всего было запущено тестов - " + totalTestCount + ",\n"
                + "Количество тестов, завершившихся неудачно - " + failedTestsCount + ",\n"
                + "Количество успешных тестов -  " + passedTestCount;
    }

    public void addTotalCount()
    {
        totalTestCount++;
    }

    public void addPassedTestCount()
    {
        passedTestCount++;
    }

    public void addFailedTestsCount()
    {
        failedTestsCount++;
    }

    private void clearStatistic(){
        totalTestCount = 0;
        passedTestCount = 0;
        failedTestsCount = 0;
        testResultInfo = "";
    }

    public void printTestsStatistic(){
        System.out.println(testResultInfo);
        clearStatistic();
    }
}
