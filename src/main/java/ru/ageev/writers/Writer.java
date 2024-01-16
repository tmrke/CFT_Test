package ru.ageev.writers;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Writer<E> {
    protected List<E> list;
    protected String prefix = "";
    protected String FILE_NAME;
    protected String path;
    protected boolean append;

    public Writer(List<E> list, String path, boolean append) {
        this.list = list;
        this.path = path;
        this.append = append;
    }

    public void writeListToFile() {
        if (list != null && !list.isEmpty()) {
            try (FileWriter fileWriter = new FileWriter(path + "/" + prefix + FILE_NAME, append)) {
                for (E element : list) {
                    fileWriter.write(element.toString());
                    fileWriter.write(System.lineSeparator());
                }
            } catch (IOException e) {
                throw new RuntimeException("Ошибка при записи в файл " + FILE_NAME);
            }
        }
    }
}
