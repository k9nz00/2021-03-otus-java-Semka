package ru.otus.hw06.framework;

public class TestsProgress {

    private int totalTestCount = 0;
    private int passedTestCount = 0;
    private int failedTestsCount = 0;

    public int getTotalTestCount() {
        return totalTestCount;
    }

    public int getPassedTestCount() {
        return passedTestCount;
    }

    public int getFailedTestsCount() {
        return failedTestsCount;
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

    public void clearStatistic(){
        totalTestCount = 0;
        passedTestCount = 0;
        failedTestsCount = 0;
    }
}
