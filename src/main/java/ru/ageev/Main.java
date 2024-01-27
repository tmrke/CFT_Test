package ru.ageev;

import ru.ageev.manager.ProgramManager;


public class Main {
    public static void main(String[] args) {
        String[] arguments = new String[]{"s", "-a", "-p", "sample-", "in1.txt"};

        ProgramManager programManager = new ProgramManager();
        programManager.startProgram(args);
    }
}

//java -jar target\CFT_Test-1.0-SNAPSHOT.jar -f -a -p sample- in1.txt in2.txt