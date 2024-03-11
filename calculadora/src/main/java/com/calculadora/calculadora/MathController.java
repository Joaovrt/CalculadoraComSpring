package com.calculadora.calculadora;

import org.springframework.web.bind.annotation.RestController;

import com.calculadora.calculadora.exceptions.UnsupportedMathOperationException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {

    @RequestMapping(value="/sum/{numOne}/{numTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo )
    throws Exception{
        if(!isNumeric(numOne)||!isNumeric(numTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numOne)+convertToDouble(numTwo);
    }

    private Double convertToDouble(String strNumber) {
       if(strNumber==null) return 0D;
       String number  = strNumber.replaceAll(",",".");
       if (isNumeric(number)) return Double.parseDouble(number);
       return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber==null) return false;
        String number  = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
