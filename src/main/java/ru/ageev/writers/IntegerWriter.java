package ru.ageev.writers;

import ru.ageev.models.Options;

import java.util.List;

public class IntegerWriter extends Writer<Integer> {
    public IntegerWriter(Options options) {
        super(options);
        FILE_NAME = "integers.txt";
    }

    @Override
    public void writeListToFile(List<Integer> list) {
        super.writeListToFile(list);
    }
}
