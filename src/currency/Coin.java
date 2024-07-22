package currency;

public class Coin {

    private String result;
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double conversion_result;

    public Coin(ExchangeRateValues exchangeRateValues){
        this.result = exchangeRateValues.result();
        this.base_code = exchangeRateValues.base_code();
        this.target_code = exchangeRateValues.target_code();
        this.conversion_rate = exchangeRateValues.conversion_rate();
        this.conversion_result = exchangeRateValues.conversion_result();
    }

    public double getConversion_result() {
        return conversion_result;
    }
}
