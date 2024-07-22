package temperature;

public enum Temperature {
    CELSIUS("°C", "Celsius"),
    KELVIN("°K", "Kelvin"),
    FAHRENHEIT("°F", "Fahrenheit"),
    RANKINE("°R", "Rankine");


    private String symbol;
    private String name;

    Temperature(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }


    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
