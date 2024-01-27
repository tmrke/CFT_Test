package ru.ageev.manager;

import ru.ageev.readers.Reader;
import ru.ageev.utils.TypeDetector;
import ru.ageev.models.Options;
import ru.ageev.statistics.Statistic;
import ru.ageev.statistics.full_statistic.FullStatisticNumber;
import ru.ageev.statistics.full_statistic.FullStatisticString;
import ru.ageev.statistics.small_statistic.SmallStatistic;
import ru.ageev.writers.FloatWriter;
import ru.ageev.writers.IntegerWriter;
import ru.ageev.writers.StringWriter;

import java.io.IOException;
import java.util.List;

public class ProgramManager {

    /**
     * Запускает программу, на вход которой, падаются {@code args}
     *
     * @param args массив строк, который содержит аргументы программы
     */
    public void startProgram(String[] args) {
        Options options = OptionManager.getOptions(args);
        Reader reader = new Reader();

        String[] filesNames = options.getFileNames();

        if (filesNames.length == 0) {
            throw new RuntimeException("Не переданы имена входных файлов");
        }

        IntegerWriter integerWriter = new IntegerWriter(options);
        FloatWriter floatWriter = new FloatWriter(options);
        StringWriter stringWriter = new StringWriter(options);

        for (int i = 0; i < filesNames.length; i++) {
            try {
                List<String> lines = reader.getFileLines(options.getFileNames()[i]);

                TypeDetector typeDetector = new TypeDetector(lines);
                typeDetector.detect();

                List<Integer> integers = typeDetector.getIntegers();
                List<Float> floats = typeDetector.getFloats();
                List<String> strings = typeDetector.getStrings();

                integerWriter.writeListToFile(integers);
                floatWriter.writeListToFile(floats);
                stringWriter.writeListToFile(strings);

                calculateStatistic(options, integers, floats, strings);
            } catch (IOException e) {
                System.out.println((("По указанному пути файлы не найдены. Path - " + options.getPath()
                        + ". Либо некорректное имя файла: " + options.getFileNames()[i])));
            }
        }
    }

    /**
     * Собирает статистику по каждому типу данных исходя из переданных {@code options}
     *
     * @param options опции программы
     * @param integers список целочисленных значений
     * @param floats список значений с плавающей запятой
     * @param strings список строк
     */
    public void calculateStatistic(Options options, List<Integer> integers, List<Float> floats, List<String> strings) {
        Statistic integerStatistic;
        Statistic floatStatistic;
        Statistic stringStatistic;

        if (options.isFullStatistic()) {
            integerStatistic = new FullStatisticNumber<>(integers);
            floatStatistic = new FullStatisticNumber<>(floats);
            stringStatistic = new FullStatisticString(strings);
        } else {
            integerStatistic = new SmallStatistic<>(integers);
            floatStatistic = new SmallStatistic<>(floats);
            stringStatistic = new SmallStatistic<>(strings);
        }

        floatStatistic.printStatistic();
        integerStatistic.printStatistic();
        stringStatistic.printStatistic();
    }
}