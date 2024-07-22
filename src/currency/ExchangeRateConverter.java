package currency;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateConverter {

    private final String api_key = "c7d3d1eae5cfcbe60b9752c7";
    private String baseCurrency;
    private String targetCurrency;
    private double amount;

    public String exchangeRateUrl(String baseCurrency, String targetCurrency, String amount) {
        // Setting URL
        // https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT

        String baseCurrencyCode = baseCurrency.substring(baseCurrency.length() - 3 );
        String targetCurrencyCode = targetCurrency.substring(targetCurrency.length() - 3);

        if (amount.isEmpty()){
            amount = "0";
        }

        String url_str = "https://v6.exchangerate-api.com/v6/" + api_key + "/pair/" +
                baseCurrencyCode + "/" + targetCurrencyCode + "/" + amount;

        System.out.println(url_str);
        return url_str;
    }

    public ExchangeRateValues exchangeRateBody(String url, Gson file){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

//            System.out.println(response.body());
            return file.fromJson(response.body(), ExchangeRateValues.class);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getAmount() {
        return amount;
    }

}
