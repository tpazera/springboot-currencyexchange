package pl.tpazera.currencyexchange.controller;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

public interface Validator {
    Boolean validate(String input) throws MalformedURLException, ParserConfigurationException;
}
