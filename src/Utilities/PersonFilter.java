package Utilities;

/**
 * Created by aseber on 4/9/16.
 */
public enum PersonFilter {

    UNSPECIFIED(1, "Unspecified"),
    ALL(2, ""),
    ANDY(4, "Andy"),
    DAVID(8, "David"),
    KYLE(16, "Kyle"),
    SAM(32, "Sam"),
    AUSTIN(64, "Austin"),
    MICHAEL(128, "Michael");

    private final String name;

    PersonFilter(int value, String name) {

        int value1 = value;
        this.name = name;

    }

    public String toString() {

        return name;

    }

}
