package ru.ageev;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static final String DEFAULT_PATH = "src/main/resources/input/";
    private final String path;

    public Reader(String path) {
        if (path == null || path.equals("")) {
            this.path = DEFAULT_PATH;
        } else {
            this.path = path;
        }
    }

    public Reader() {
        path = DEFAULT_PATH;
    }

    public List<String> getFileLines(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "/" + fileName))) {
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    lines.add(line.trim());
                }
            }

            return lines;
        } catch (IOException e) {
            throw new RuntimeException(("По указанному пути файлы не найдены. Path - " + path));
        }
    }
}