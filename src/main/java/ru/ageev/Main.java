package ru.ageev;

import ru.ageev.writers.FloatWriter;
import ru.ageev.writers.IntegerWriter;
import ru.ageev.writers.StringWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader("src/main/resources/input/in1.txt");
        List<String> lines = reader.getFileLines();

        TypeDetector typeDetector = new TypeDetector(lines);
        typeDetector.detect();

        List<Integer> integers = typeDetector.getIntegers();
        List<Float> floats = typeDetector.getFloats();
        List<String> strings = typeDetector.getStrings();

        IntegerWriter integerWriter = new IntegerWriter(integers, "src/main/resources/input", true);
        integerWriter.writeListToFile();

        FloatWriter floatWriter = new FloatWriter(floats, "src/main/resources/input", false);
        floatWriter.writeListToFile();

        StringWriter stringWriter = new StringWriter(strings, "src/main/resources/input", true);
        stringWriter.writeListToFile();

        /*TODO
            1. Сделать так, что бы при чтении запоминался путь и мог передаваться в запись
            2. Реализовать нормальное добавление префикса
            3. Стату не делал еще
         */
    }
}