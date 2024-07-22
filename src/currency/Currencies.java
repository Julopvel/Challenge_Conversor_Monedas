package currency;

import java.util.Currency;
import java.util.Locale;

public enum Currencies {
    USD("USD", Currency.getInstance("USD").getDisplayName(Locale.ENGLISH)),
    COP("COP", Currency.getInstance("COP").getDisplayName(Locale.ENGLISH)),
    EUR("EUR", Currency.getInstance("EUR").getDisplayName(Locale.ENGLISH)),
    MXN("MXN", Currency.getInstance("MXN").getDisplayName(Locale.ENGLISH)),
    JPY("JPY", Currency.getInstance("JPY").getDisplayName(Locale.ENGLISH)),
    CNY("CNY", Currency.getInstance("CNY").getDisplayName(Locale.ENGLISH));


    private String symbol;
    private String name;

    private Currencies(String symbol, String name) {
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
