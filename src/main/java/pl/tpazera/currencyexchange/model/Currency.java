package pl.tpazera.currencyexchange.model;

public class Currency {

    private String name;
    private Integer converter;
    private String code;
    private Float exchange;

    public Currency(String name_val, Integer converter_val, String code_val, Float exchange_val) {
        name = name_val;
        converter = converter_val;
        code = code_val;
        exchange = exchange_val;
    }

    public String getName() {
        return name;
    }

    public Integer getConverter() {
        return converter;
    }

    public String getCode() {
        return code;
    }

    public Float getExchange() {
        return exchange;
    }
}
