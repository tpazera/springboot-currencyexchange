package pl.tpazera.currencyexchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.tpazera.currencyexchange.model.Currency;
import pl.tpazera.currencyexchange.model.CurrencyList;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {

    private Converter converter;

    @GetMapping
    public String home(Map<String, Object> model) throws MalformedURLException, ParserConfigurationException {
        Provider xml = new ProviderXML();
        List<Currency> currencyList = xml.getData();
        CurrencyList currencyListObject = new CurrencyList(xml.getData());
        ValidatorInput validatorInput = new ValidatorInput();
        ValidatorCurrency validatorCurrency = new ValidatorCurrency();
        converter = new Converter(currencyListObject, validatorInput, validatorCurrency);
        model.put("currencylist", currencyList);

        return "home";
    }

    @PostMapping
    public String formSubmit(@RequestParam("fromValue") String fromValue, RedirectAttributes model, @RequestParam("fromRadio") String fromRadio, @RequestParam("toRadio") String toRadio) throws MalformedURLException, ParserConfigurationException {
        if(fromValue.contains(",")) fromValue = fromValue.substring(fromValue.lastIndexOf(',')+1, fromValue.length());
        if(fromRadio.contains(",")) fromRadio = fromRadio.substring(fromRadio.lastIndexOf(',')+1, fromRadio.length());
        if(toRadio.contains(",")) toRadio = toRadio.substring(toRadio.lastIndexOf(',')+1, toRadio.length());
        Float outcome = converter.exchange(fromValue, fromRadio, toRadio);

        if(outcome == null) {
            return "redirect:/?fromValue=100.0&fromRadio=PLN&toRadio=PLN&outcome=ERROR";
        }

        return "redirect:/?fromValue="+fromValue+"&fromRadio="+fromRadio+"&toRadio="+toRadio+"&outcome="+outcome;
    }

}