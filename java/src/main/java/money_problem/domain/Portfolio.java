package money_problem.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    public boolean empty = true;
    public HashMap<Integer, Currency> count = new HashMap<>();
    public ArrayList<Money> countMoney = new ArrayList<>();
    public void add(int amount, Currency currency) {
        this.empty = false;
        this.count.put(amount, currency);

        this.add(new Money(amount, currency));
    }

    public void add(Money money){
        this.countMoney.add(money);
    }

    public double evaluate(Currency to, Bank withExchangeRate) {
        int result = 0;
        for (Money money : this.countMoney) {
            try {
                result += withExchangeRate.convertFromTo(money.value, money.currency, to);
            } catch (MissingExchangeRateException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
