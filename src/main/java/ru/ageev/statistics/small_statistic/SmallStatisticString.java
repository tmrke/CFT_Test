package ru.ageev.statistics.small_statistic;

import ru.ageev.statistics.Statistic;

import java.util.List;

public class SmallStatisticString implements Statistic {
    protected int elementsCount;
    protected List<String> list;

    public SmallStatisticString(List<String> list) {
        this.list = list;
    }

    @Override
    public void printStatistic() {
        elementsCount = list.size();
        System.out.println("Количество записанных строк = " + elementsCount);
    }
}
