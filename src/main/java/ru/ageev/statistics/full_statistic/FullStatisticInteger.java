package ru.ageev.statistics.full_statistic;

import ru.ageev.statistics.Statistic;
import ru.ageev.statistics.small_statistic.SmallStatisticNumber;

import java.util.List;

public class FullStatisticInteger extends SmallStatisticNumber implements Statistic {
    protected int minValue;
    protected int maxValue;
    protected double averageValue;
    protected int sum;

    public FullStatisticInteger(List<Integer> list) {
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
            minValue = list.stream().min((o1, o2) -> 0).get();
            maxValue = list.stream().max((o1, o2) -> 0).get();
            averageValue = (float) list.stream().mapToDouble(value -> (double) value).average().orElse(0);
            sum = (int) list.stream().mapToDouble(value -> (double) value).sum();
        }
    }
}
