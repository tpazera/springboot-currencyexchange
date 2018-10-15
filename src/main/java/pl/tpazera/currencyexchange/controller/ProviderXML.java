package pl.tpazera.currencyexchange.controller;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import pl.tpazera.currencyexchange.model.Currency;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProviderXML implements Provider {

    public List<Currency> getData() throws ParserConfigurationException, MalformedURLException {

        List<Currency> currencyList = new ArrayList<Currency>();

        URL url = new URL("https://www.nbp.pl/kursy/xml/LastA.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = null;
        try {
            doc = db.parse(url.openStream());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NodeList xmlPositions = doc.getElementsByTagName("pozycja");

        currencyList.add(new Currency("złoty", 1, "PLN", (float) 1.0));

        for(int i = 0; i < xmlPositions.getLength(); i++) {
            Node xmlItem = xmlPositions.item(i);

            if (xmlItem.getNodeType() == Node.ELEMENT_NODE) {

                Element el = (Element) xmlItem;

                String name = el.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                Integer converter = Integer.valueOf(el.getElementsByTagName("przelicznik").item(0).getTextContent());
                String code = el.getElementsByTagName("kod_waluty").item(0).getTextContent();
                String exchangeString = el.getElementsByTagName("kurs_sredni").item(0).getTextContent();
                Float exchange = Float.valueOf(exchangeString.replace(',','.'));

                currencyList.add(new Currency(name, converter, code, exchange));

            }
        }

        return currencyList;
    }
}
