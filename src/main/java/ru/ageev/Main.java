package ru.ageev;

import ru.ageev.manager.ProgramManager;


public class Main {
    public static void main(String[] args) {
        String[] arguments = new String[]{"-o", "D:\\programming\\projects\\CFT_Test\\src\\main\\resources", "s", "-a", "-p", "sample-", "in1.txt"};

        ProgramManager programManager = new ProgramManager();
        programManager.startProgram(arguments);
    }
}

//java -jar target\CFT_Test-1.0-SNAPSHOT.jar -o G:\programming\projects\CFT_Test\src\main\resources\output -f -a -p sample- in1.txt in2.txt
//java -jar target\CFT_Test-1.0-SNAPSHOT.jar  -f -a -p sample- in1.txt in2.txt
// -o path -f -a -p sample- in1.txt in2.txt