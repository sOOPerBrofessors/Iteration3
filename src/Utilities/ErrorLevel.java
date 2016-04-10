package Utilities;

/**
 * Created by aseber on 4/9/16.
 */
public enum ErrorLevel {

    NOTICE(1, "Notice"), // Trivial things to print out, e.g. just letting us know something was loaded
    WARNING(2, "Warning"), // A possible small error
    ERROR(4, "Error"), // A large game error, however not game breaking
    CRITICAL(8, "Critical Error"), // A critical error that usually results in a crash
    NONE(16, "None"); // Not recommended to use unless you want no messages to show up

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
