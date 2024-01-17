package ru.ageev.statistics;

public abstract class FullStatistic extends SmallStatistic implements Statistic {
    protected FullStatistic(int integersElementsCount, int floatsElementsCount, int stringsElementsCount) {
        super(integersElementsCount, floatsElementsCount, stringsElementsCount);
    }
}
