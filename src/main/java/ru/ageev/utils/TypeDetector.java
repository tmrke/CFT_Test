package ru.ageev.utils;

import java.util.ArrayList;
import java.util.List;

public class TypeDetector {
    private final List<String> lines;
    private final List<Integer> integers = new ArrayList<>();
    private final List<String> strings = new ArrayList<>();
    private final List<Float> floats = new ArrayList<>();

    public TypeDetector(List<String> lines) {
        this.lines = lines;
    }
    public List<Integer> getIntegers() {
        return integers;
    }
    public List<String> getStrings() {
        return strings;
    }
    public List<Float> getFloats() {
        return floats;
    }

    /**
     * Проверяет каждый элемент списка строк {@code lines} на то является ли это значение Integer, Float или String
     * и записывает его в соотвествующих типу данных список
     */
    public void detect() {
        for (String line : lines) {
            if (isInteger(line)) {
                integers.add(Integer.valueOf(line));
            } else if (isFloat(line)) {
                floats.add(Float.valueOf(line));
            } else {
                strings.add(line);
            }
        }
    }

    /**
     * Проверяет, является ли {@code line} Integer
     * @param line строка подлежащая проверке
     * @return true, если {@code line} является объектом типа Integer
     */
    private boolean isInteger(String line) {
        try {
            Integer.valueOf(line);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Проверяет, является ли {@code line} Float
     * @param line строка подлежащая проверке
     * @return true, если {@code line} является объектом типа Float
     */
    private boolean isFloat(String line) {
        try {
            Float.valueOf(line);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}