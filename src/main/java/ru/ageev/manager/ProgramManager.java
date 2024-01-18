package ru.ageev.manager;

import ru.ageev.Reader;
import ru.ageev.TypeDetector;
import ru.ageev.models.Options;
import ru.ageev.statistics.Statistic;
import ru.ageev.statistics.full_statistic.FullStatisticFloat;
import ru.ageev.statistics.full_statistic.FullStatisticInteger;
import ru.ageev.statistics.full_statistic.FullStatisticString;
import ru.ageev.writers.FloatWriter;
import ru.ageev.writers.IntegerWriter;
import ru.ageev.writers.StringWriter;

import java.util.List;

public class ProgramManager {
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
            List<String> lines = reader.getFileLines(options.getFileNames()[i]);

            TypeDetector typeDetector = new TypeDetector(lines);
            typeDetector.detect();

            List<Integer> integers = typeDetector.getIntegers();
            List<Float> floats = typeDetector.getFloats();
            List<String> strings = typeDetector.getStrings();

            integerWriter.writeListToFile(integers);
            floatWriter.writeListToFile(floats);
            stringWriter.writeListToFile(strings);

            calculateIntegerStatistic(integers, floats, strings);
        }
    }

    public void calculateIntegerStatistic(List<Integer> integers, List<Float> floats, List<String> strings) {
        Statistic integerStatistic = new FullStatisticInteger(integers);
        integerStatistic.printStatistic();

        Statistic floatStatistic = new FullStatisticFloat(floats);
        floatStatistic.printStatistic();

        Statistic stringStatistic = new FullStatisticString(strings);
        stringStatistic.printStatistic();
    }
}