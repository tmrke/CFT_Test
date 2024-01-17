package ru.ageev.models;

public class Options {
    private static final String DEFAULT_PATH = "src/main/resources/input";
    private boolean isFullStatistic;        // -s / -f
    private boolean appendMode;             // -a
    private String prefix = "";             // -p
    private String path = DEFAULT_PATH;     // -o
    private String[] fileNames;

    public boolean isFullStatistic() {
        return isFullStatistic;
    }

    public void setFullStatistic(boolean fullStatistic) {
        isFullStatistic = fullStatistic;
    }

    public boolean isAppendMode() {
        return appendMode;
    }

    public void setAppendMode(boolean appendMode) {
        this.appendMode = appendMode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getFileNames() {
        return fileNames;
    }

    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }
}
