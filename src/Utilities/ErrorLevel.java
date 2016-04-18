package Utilities;

/**
 * Created by aseber on 4/9/16.
 */
public enum ErrorLevel {

    DEV(1, "Dev"),
    NOTICE(2, "Notice"), // Trivial things to print out, e.g. just letting us know something was loaded
    WARNING(4, "Warning"), // A possible small error
    ERROR(8, "Error"), // A large game error, however not game breaking
    CRITICAL(16, "Critical Error"), // A critical error that usually results in a crash
    NONE(32, "None"); // Not recommended to use unless you want no messages to show up

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
