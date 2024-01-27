package ru.ageev.statistics.full_statistic;


import ru.ageev.statistics.Statistic;
import ru.ageev.statistics.small_statistic.SmallStatistic;

import java.util.List;

public class FullStatisticNumber<E extends Number> extends SmallStatistic<E> implements Statistic {
    protected double minValue;
    protected double maxValue;
    protected double averageValue;
    protected double sum;

    public FullStatisticNumber(List<E> list) {
        super(list);
    }

    @Override
    public void printStatistic() {
        calculateStatistic(list);

        if (!list.isEmpty()) {
            if (list.get(0) instanceof Integer) {
                System.out.println("Полная статистика для Integer:");
            } else if (list.get(0) instanceof Float) {
                System.out.println("Полная статистика для Float:");
            } else {
                throw new RuntimeException("Список содержит неверный тип данных: " + list.get(0).getClass().toString());
            }
        }

        System.out.println("Количество записанных строк = " + elementsCount);
        System.out.println("Минимальное записанное значение = " + minValue);
        System.out.println("Максимальное записанное значение = " + maxValue);
        System.out.println("Среднее значение записанных чисел = " + averageValue);
        System.out.println("Суммарное значение записанных чисел = " + sum + System.lineSeparator());
    }


    /**
     * Вычисляет статистику по переданным данным
     *
     * @param list список числовых значений, подлежащих вычислению статистики
     */
    private void calculateStatistic(List<E> list) {
        if (!list.isEmpty()) {
            minValue = list.stream().mapToDouble(Number::doubleValue).min().orElse(0);
            maxValue = list.stream().mapToDouble(Number::doubleValue).max().orElse(0);
            averageValue = list.stream().mapToDouble(Number::doubleValue).average().orElse(0);
            sum = list.stream().mapToDouble(Number::doubleValue).sum();
        }
    }
}

