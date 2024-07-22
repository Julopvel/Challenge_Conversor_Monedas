package time;

public enum Time {
    YEAR("Year"),
    WEEK("Week"),
    DAY("Day"),
    HOUR("Hour"),
    MINUTE("Minute"),
    SECOND("Second");

    private String name;

    Time(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
