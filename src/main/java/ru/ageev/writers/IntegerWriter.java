package ru.ageev.writers;

import java.util.List;

public class IntegerWriter extends Writer<Integer> {
    public IntegerWriter(List<Integer> integers, String path, boolean append) {
        super(integers, path, append);
        FILE_NAME = "integers.txt";
    }

    @Override
    public void writeListToFile() {
        super.writeListToFile();
    }
}
