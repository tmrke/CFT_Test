package ru.ageev;

import ru.ageev.manager.ProgramManager;


public class Main {
    public static void main(String[] args) {
        String[] arguments = new String[]{"-o", "src/main/resources/output", "-f", "-a", "-p", "sample-", "in1.txt"};
        ProgramManager programManager = new ProgramManager();
        programManager.startProgram(arguments);
    }
}