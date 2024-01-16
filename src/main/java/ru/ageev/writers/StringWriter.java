package ru.ageev.writers;

import java.util.List;

public class StringWriter extends Writer<String> {
    public StringWriter(List<String> list, String path, boolean append) {
        super(list, path, append);
        FILE_NAME = "strings.txt";
    }

    @Override
    public void writeListToFile() {
        super.writeListToFile();
    }
}
