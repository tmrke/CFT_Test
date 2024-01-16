package ru.ageev.type;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenericWriter<E> {

    public void writeListToFile(List<E> list, FileWriter fileWriter) {
        for (E element : list) {
            try {
                fileWriter.write(element.toString());
            } catch (IOException e) {
                throw new RuntimeException("Ошибка при записи в файл элемента element = " + element);
            }
        }
    }
}
