package money_problem.domain;

import java.util.Map;
import java.util.HashMap;

public class BankBuilder {

    private Map<Currency, Double> exchangeRate;
    private Currency pivotCurrency;

    public void setExchangeRate(Map<Currency, Double> exchangeRate){
        this.exchangeRate = exchangeRate;
    }
    public void setPivotCurrency(Currency pivotCurrency){
        this.pivotCurrency = pivotCurrency;
    }

    public Bank build(){
        Map<String, Double> exchangeRates = new HashMap<String, Double>();
        for (var rate : exchangeRate.entrySet()){
            exchangeRates.put(pivotCurrency+"->"+rate.getKey(), rate.getValue());
        }
        Bank bank = new Bank(exchangeRates);

        return bank;
    }
}
