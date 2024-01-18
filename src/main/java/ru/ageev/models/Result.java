package ru.ageev.models;

import java.util.List;

public class Result {
    private List<Integer> integers;
    private List<Float> floats;
    private List<String> strings;

    public Result(List<Integer> integers, List<Float> floats, List<String> strings) {
        this.integers = integers;
        this.floats = floats;
        this.strings = strings;
    }


    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public List<Float> getFloats() {
        return floats;
    }

    public void setFloats(List<Float> floats) {
        this.floats = floats;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

}