package pl.tpazera.currencyexchange.controller;

import pl.tpazera.currencyexchange.model.Currency;
import pl.tpazera.currencyexchange.model.CurrencyList;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;
import java.util.List;

public class ValidatorCurrency implements Validator {

    @Override
    public Boolean validate(String _currency) throws MalformedURLException, ParserConfigurationException {
        Provider xml = new ProviderXML();
        List<Currency> currencyList = xml.getData();
        CurrencyList currencyListObject = new CurrencyList(xml.getData());
        Currency currency = currencyListObject.getCurrencyByCode(_currency);
        if(currency.equals(null)) return false;
        return true;
    }
}
