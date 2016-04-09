package Utilities;

/**
 * Created by aseber on 4/9/16.
 */
public enum ErrorLevel {

    NOTICE(1, "Notice"),
    WARNING(2, "Warning"),
    ERROR(4, "Error"),
    CRITICAL(8, "Critical Error");

    private int level;
    private String name;

    ErrorLevel(int level, String name) {

        this.level = level;
        this.name = name;

    }

    public int compare(ErrorLevel other) {

        return (int) Math.signum(this.level - other.level);

    }

    public String toString() {

        return name;

    }

}
