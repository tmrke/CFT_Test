package ru.ageev.manager;

import ru.ageev.models.Options;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionManager {
    private static final String FULL_STATISTIC_OPTION = "-f";
    private static final String SMALL_STATISTIC_OPTION = "-s";
    private static final String APPEND_MODE_OPTION = "-a";
    private static final String PREFIX_OPTION = "-p";
    private static final String OUTPUT_PATH_OPTION = "-o";

    public static Options getOptions(String[] args) {
        Options options = new Options();
        int argumentCount = 0;

        for (int i = 0; i < args.length - 1; i++) {
            String currentArgument = args[i];

            switch (currentArgument) {
                case (FULL_STATISTIC_OPTION) -> {
                    options.setFullStatistic(true);
                    System.out.println("Собирается полная статистика");
                    argumentCount++;
                }

                case (SMALL_STATISTIC_OPTION) -> {
                    options.setFullStatistic(false);
                    System.out.println("Собирается малая статистика");
                    argumentCount++;
                }

                case (APPEND_MODE_OPTION) -> {
                    options.setAppendMode(true);
                    System.out.println("Режим записи в существующие файлы");
                    argumentCount++;
                }

                case (PREFIX_OPTION) -> {
                    String prefix = args[++i];
                    options.setPrefix(prefix);
                    System.out.println("К файлам добавляется префикс: " + prefix);
                    argumentCount = argumentCount + 2;
                }

                case (OUTPUT_PATH_OPTION) -> {
                    String path = args[++i];
                    options.setPath(path);
                    System.out.println("Файлы записываются по пути: " + path);
                    argumentCount = argumentCount + 2;
                }

                default -> {
                    System.out.println("Неизвестный аргумент: \"" + currentArgument + "\"");
                    argumentCount++;
                }
            }
        }

        List<String> filesNames = new ArrayList<>(Arrays.asList(args).subList(argumentCount, args.length));
        options.setFileNames(filesNames.toArray(new String[0]));

        return options;
    }
}