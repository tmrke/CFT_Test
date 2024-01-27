package ru.ageev.writers;


import ru.ageev.models.Options;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

abstract class Writer<E> {
    protected String FILE_NAME;
    protected Options options;

    public Writer(Options options) {
        this.options = options;
    }

    /**
     * Записывает список данных в файл с названием {@code FILE_NAME}
     *
     * @param list список данных подлежащих записи в файл
     */
    public void writeListToFile(List<E> list) {
        String fullPath = options.getPath() + "\\" + options.getPrefix() + FILE_NAME;

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
