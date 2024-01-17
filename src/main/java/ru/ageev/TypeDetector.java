package ru.ageev;

import java.util.ArrayList;
import java.util.List;

public class TypeDetector {
    private List<String> lines;
    private List<Integer> integers = new ArrayList<>();
    private List<String> strings = new ArrayList<>();
    private List<Float> floats = new ArrayList<>();

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

    private boolean isInteger(String line) {
        try {
            Integer.valueOf(line);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isFloat(String line) {
        try {
            Float.valueOf(line);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
