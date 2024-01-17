package ru.ageev.statistics;

public class SmallStatistic implements Statistic {
    protected final int integersElementsCount;
    protected final int floatsElementsCount;
    protected final int stringsElementsCount;

    public SmallStatistic(int integersElementsCount, int floatsElementsCount, int stringsElementsCount) {
        this.integersElementsCount = integersElementsCount;
        this.floatsElementsCount = floatsElementsCount;
        this.stringsElementsCount = stringsElementsCount;
    }

    @Override
    public void printStatistic() {
        System.out.println("Количество записанных целочисленных значений в файл = " + integersElementsCount);
        System.out.println("Количество записанных дробных значений в файл = " + floatsElementsCount);
        System.out.println("Количество записанных строк в файл = " + stringsElementsCount);
    }
}
