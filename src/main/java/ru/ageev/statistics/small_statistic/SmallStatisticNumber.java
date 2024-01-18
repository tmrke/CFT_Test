package ru.ageev.statistics.small_statistic;

import ru.ageev.statistics.Statistic;

import java.util.List;

public class SmallStatisticNumber<E> implements Statistic {
    protected int elementsCount;
    protected List<E> list;

    public SmallStatisticNumber(List<E> list) {
        this.list = list;
    }

    @Override
    public void printStatistic() {
        elementsCount = list.size();
        System.out.println("Количество записанных строк = " + elementsCount);
    }
}
