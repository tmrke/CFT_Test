package ru.ageev.writers;


import ru.ageev.models.Options;
import ru.ageev.statistics.Statistic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Writer<E> {
    protected String FILE_NAME;
    protected Options options;
    protected Statistic statistic;

    public Writer(Options options) {
        this.options = options;
    }

    public void writeListToFile(List<E> list) {
        String fullPath = options.getPath() + "/" + options.getPrefix() + FILE_NAME;

        if (list != null && !list.isEmpty()) {
            try (FileWriter fileWriter = new FileWriter(fullPath, options.isAppendMode())) {
                for (E element : list) {
                    fileWriter.write(element.toString());
                    fileWriter.write(System.lineSeparator());
                }
            } catch (IOException e) {
                throw new RuntimeException("Невозможно записать файл по указанному пути: " + fullPath);
            }
        }
    }
}
