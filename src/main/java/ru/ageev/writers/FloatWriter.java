package ru.ageev.writers;

import ru.ageev.models.Options;

import java.util.List;

public class FloatWriter extends Writer<Float> {
    public FloatWriter(Options options) {
        super(options);
        FILE_NAME = "floats.txt";
    }

    @Override
    public void writeListToFile(List<Float> list) {
        super.writeListToFile(list);
    }
}

