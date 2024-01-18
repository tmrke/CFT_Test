package ru.ageev.statistics.small_statistic;

import ru.ageev.statistics.Statistic;

import java.util.List;

public class SmallStatistic<E> implements Statistic {
    protected int elementsCount;
    protected List<E> list;

    public SmallStatistic(List<E> list) {
        this.list = list;
        elementsCount = list.size();
    }

    @Override
    public void printStatistic() {
        if (!list.isEmpty()) {
            if (list.get(0) instanceof Integer) {
                System.out.println("Малая статистика для Integer:");
            } else if (list.get(0) instanceof Float) {
                System.out.println("Малая статистика для Float:");
            } else if (list.get(0) instanceof String) {
                System.out.println("Малая статистика для String:");
            } else {
                throw new RuntimeException("Список содержит неверный тип данных: " + list.get(0).getClass().toString());
            }
        }

        System.out.println("Количество записанных строк = " + elementsCount + System.lineSeparator());
    }
}
