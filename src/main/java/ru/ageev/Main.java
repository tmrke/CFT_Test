package ru.ageev;

import ru.ageev.manager.ProgramManager;


public class Main {
    public static void main(String[] args) {
        String[] arguments = new String[]{"-o", "src/main/resources/output", "-s", "-a", "-p", "sample-", "in1.txt"};
        ProgramManager programManager = new ProgramManager();
        programManager.startProgram(arguments);
    }
}

/*TODO
           1. Сделать так, что бы при чтении запоминался путь и мог передаваться в запись
           3. Статистику переделать так, что бы интефрейс был общий Statistic -> Классы Для строк и для чисел -> полная и малая
           Или вообще подумать, можно ли объединить статистику строк и чисел к одному интерфейсу
*/