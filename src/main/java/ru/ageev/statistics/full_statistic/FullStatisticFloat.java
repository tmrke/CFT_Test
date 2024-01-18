package ru.ageev.statistics.full_statistic;


import ru.ageev.statistics.Statistic;
import ru.ageev.statistics.small_statistic.SmallStatisticNumber;

import java.util.List;

public class FullStatisticFloat extends SmallStatisticNumber implements Statistic {
    protected double minValue;
    protected double maxValue;
    protected double averageValue;
    protected double sum;

    public FullStatisticFloat(List<Float> list) {
        super(list);
    }

    @Override
    public void printStatistic() {
        calculateStatistic(list);

        System.out.println("Количество записанных строк = " + elementsCount);
        System.out.println("Минимально записанное значение = " + minValue);
        System.out.println("Максимально записанное значение = " + maxValue);
        System.out.println("Среднее значение записанных чисел = " + averageValue);
        System.out.println("Суммарное значение записанных чисел = " + sum);
    }


    private void calculateStatistic(List<Integer> list) {
        if (!list.isEmpty()) {
            minValue = list.stream().mapToDouble(value -> value).min().orElse(0);
            maxValue = list.stream().mapToDouble(value -> value).max().orElse(0);
            averageValue = list.stream().mapToDouble(value -> (double) value).average().orElse(0);
            sum = (int) list.stream().mapToDouble(value -> (double) value).sum();
        }
    }
}

