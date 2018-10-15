package pl.tpazera.currencyexchange.controller;

import pl.tpazera.currencyexchange.model.Currency;
import pl.tpazera.currencyexchange.model.CurrencyList;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

public class Converter {

    private CurrencyList currencyList;
    private ValidatorInput validatorInput;
    private ValidatorCurrency validatorCurrency;

    public Converter(CurrencyList _currencyList, ValidatorInput _validatorInput, ValidatorCurrency _validatorCurrency) {
        currencyList = _currencyList;
        validatorInput = _validatorInput;
        validatorCurrency = _validatorCurrency;
    }

    public Float exchange(String _fromValue, String _fromCurrency, String _toCurrency) throws MalformedURLException, ParserConfigurationException {
        if(validatorInput.validate(_fromValue) && validatorCurrency.validate(_fromCurrency) && validatorCurrency.validate(_toCurrency)) {
            Currency fromCurrency = currencyList.getCurrencyByCode(_fromCurrency);
            Currency toCurrency = currencyList.getCurrencyByCode(_toCurrency);
            Float fromValue = Float.parseFloat(_fromValue);
            Float outcome = fromValue * (toCurrency.getConverter() / toCurrency.getExchange()) / (fromCurrency.getConverter() / fromCurrency.getExchange());
            return outcome;
        } else {
            return null;
        }

    }

}
