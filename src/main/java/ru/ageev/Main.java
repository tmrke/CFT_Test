package ru.ageev;

import ru.ageev.manager.OptionManager;
import ru.ageev.manager.ProgramManager;
import ru.ageev.models.Options;
import ru.ageev.writers.FloatWriter;
import ru.ageev.writers.IntegerWriter;
import ru.ageev.writers.StringWriter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] arguments = new String[]{"-o", "src/main/resources/output", "-s", "-a", "-p", "sample-", "in1.txt", "in2.txt"};
        ProgramManager.startProgram(arguments);
    }
}

/*TODO
           1. Сделать так, что бы при чтении запоминался путь и мог передаваться в запись
           3. Стату не делал еще
*/