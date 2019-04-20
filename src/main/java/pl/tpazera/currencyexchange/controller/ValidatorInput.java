package pl.tpazera.currencyexchange.controller;

public class ValidatorInput implements Validator {

    @Override
    public Boolean validate(String _input) {
        if(_input.isEmpty()) return false;
        try {
            Float input = Float.parseFloat(_input);
            if(input < 0) return false;
        } catch(Exception ex) {
            return false;
        }

        return true;
    }
}
