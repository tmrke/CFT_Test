package ru.ageev.statistics.full_statistic;

import ru.ageev.statistics.Statistic;
import ru.ageev.statistics.small_statistic.SmallStatisticString;

import java.util.Comparator;
import java.util.List;

public class FullStatisticString extends SmallStatisticString implements Statistic {
    private int maxStringLength;
    private int minStringLength;

    public FullStatisticString(List<String> list) {
        super(list);
    }

    @Override
    public void printStatistic() {
        if (!list.isEmpty()) {
            maxStringLength = list.stream().mapToInt(String::length).max().orElse(0);
            minStringLength = list.stream().mapToInt(String::length).min().orElse(0);
        }

        System.out.println("Количество записанных строк = " + elementsCount);
        System.out.println("Строка минимальной длины = " + minStringLength);
        System.out.println("Строка максимальной длины = " + maxStringLength);
    }
}
