package money_problem.domain;

import java.util.Map;
import java.util.HashMap;

public class BankBuilder {

    private Map<Currency, Float> exchangeRate;
    private final Currency pivotCurrency;
    public BankBuilder(Currency pivotCurrency){
        this.pivotCurrency = pivotCurrency;
    }

    public Currency getPivotCurrency(){
        return this.pivotCurrency;
    }
}
