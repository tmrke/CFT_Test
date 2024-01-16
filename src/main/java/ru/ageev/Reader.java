package ru.ageev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String path;
    private BufferedReader bufferedReader;

    public Reader(String path) {
        this.path = path;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("По указанному пути файлы не найдены. Path - " + path);
        }
    }

    public List<String> getFileLines() {
        List<String> lines = new ArrayList<>();
        String line;

        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException("По указанному пути файлы не найдены. Path - " + path);
            }

            if (!line.equals("")) {
                lines.add(line.trim());
            }
        }

        return lines;
    }
}
