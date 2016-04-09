package Utilities;

/**
 * Created by aseber on 4/9/16.
 */
public enum PersonFilter {

    ALL(1, ""),
    ANDY(2, "Andy"),
    DAVID(4, "David"),
    KYLE(8, "Kyle"),
    SAM(16, "Sam"),
    AUSTIN(32, "Austin"),
    MICHAEL(64, "Michael");

    private int value;
    private String name;

    PersonFilter(int value, String name) {

        this.value = value;
        this.name = name;

    }

    public String toString() {

        return name;

    }

}
