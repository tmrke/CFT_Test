package ru.ageev.readers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static final String DEFAULT_PATH = "src/main/resources/input";
    private final String path;
    public Reader() {
        path = DEFAULT_PATH;
    }

    public List<String> getFileLines(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "/" + fileName))) {
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    lines.add(line.trim());
                }
            }

            return lines;
        }
    }
}