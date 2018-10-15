package pl.tpazera.currencyexchange.model;

import java.util.List;

public class CurrencyList {

    private List<Currency> currencyList;

    public CurrencyList(List<Currency> currencyList_val) {
        currencyList = currencyList_val;
    }

    public Currency getCurrencyByCode(String code) {
        for (Currency currency : currencyList) {
            if(currency.getCode().equals(code)) {
                return currency;
            }
        }
        return null;
    }

    public Currency getCurrencyByName(String name) {
        for (Currency currency : currencyList) {
            if(currency.getName().equals(name)) {
                return currency;
            }
        }
        return null;
    }


}
