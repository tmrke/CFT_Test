package ru.ageev.writers;

import ru.ageev.models.Options;

import java.util.List;

public class StringWriter extends Writer<String> {
    public StringWriter(Options options) {
        super(options);
        FILE_NAME = "strings.txt";
    }

    @Override
    public void writeListToFile(List<String> list) {
        super.writeListToFile(list);
    }
}
