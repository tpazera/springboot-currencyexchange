package pl.tpazera.currencyexchange.controller;

import pl.tpazera.currencyexchange.model.Currency;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;
import java.util.List;

public interface Provider {
    List<Currency> getData() throws ParserConfigurationException, MalformedURLException;
}
