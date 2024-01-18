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

        for (int i = 0; i < args.length; i++) {
            String currentArgument = args[i];

            switch (currentArgument) {
                case (FULL_STATISTIC_OPTION) -> {
                    options.setFullStatistic(true);
                    argumentCount++;
                }

                case (SMALL_STATISTIC_OPTION) -> {
                    options.setFullStatistic(false);
                    argumentCount++;
                }

                case (APPEND_MODE_OPTION) -> {
                    options.setAppendMode(true);
                    argumentCount++;
                }

                case (PREFIX_OPTION) -> {
                    options.setPrefix(args[++i]);
                    argumentCount = argumentCount + 2;
                }

                case (OUTPUT_PATH_OPTION) -> {
                    options.setPath(args[++i]);
                    argumentCount = argumentCount + 2;
                }
            }
        }

        List<String> filesNames = new ArrayList<>(Arrays.asList(args).subList(argumentCount, args.length));
        options.setFileNames(filesNames.toArray(new String[0]));

        return options;
    }
}