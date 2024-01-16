package ru.ageev.writers;

import java.util.List;

public class FloatWriter extends Writer<Float> {
    public FloatWriter(List<Float> list, String path, boolean append) {
        super(list, path, append);
        FILE_NAME = "floats.txt";
    }

    @Override
    public void writeListToFile() {
        super.writeListToFile();
    }
}

