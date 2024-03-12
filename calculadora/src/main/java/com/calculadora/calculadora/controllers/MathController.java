package com.calculadora.calculadora.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.calculadora.calculadora.exceptions.UnsupportedMathOperationException;
import com.calculadora.calculadora.math.SimpleMath;
import com.calculadora.calculadora.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value="/sum/{numOne}/{numTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo )
    throws Exception{
        if(!NumberConverter.isNumeric(numOne)||!NumberConverter.isNumeric(numTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sum(NumberConverter.convertToDouble(numOne),NumberConverter.convertToDouble(numTwo));
    }

    @RequestMapping(value="/sub/{numOne}/{numTwo}", method=RequestMethod.GET)
    public Double sub(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo )
    throws Exception{
        if(!NumberConverter.isNumeric(numOne)||!NumberConverter.isNumeric(numTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sub(NumberConverter.convertToDouble(numOne),NumberConverter.convertToDouble(numTwo));
    }

    @RequestMapping(value="/mult/{numOne}/{numTwo}", method=RequestMethod.GET)
    public Double mult(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo )
    throws Exception{
        if(!NumberConverter.isNumeric(numOne)||!NumberConverter.isNumeric(numTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.mult(NumberConverter.convertToDouble(numOne),NumberConverter.convertToDouble(numTwo));
    }

    @RequestMapping(value="/div/{numOne}/{numTwo}", method=RequestMethod.GET)
    public Double div(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo )
    throws Exception{
        if(!NumberConverter.isNumeric(numOne)||!NumberConverter.isNumeric(numTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        if(NumberConverter.convertToDouble(numTwo)==0){
            throw new UnsupportedMathOperationException("NumTwo can't be zero!");
        }
        return math.div(NumberConverter.convertToDouble(numOne),NumberConverter.convertToDouble(numTwo));
    }

    @RequestMapping(value="/med/{numOne}/{numTwo}", method=RequestMethod.GET)
    public Double med(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo )
    throws Exception{
        if(!NumberConverter.isNumeric(numOne)||!NumberConverter.isNumeric(numTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.med(NumberConverter.convertToDouble(numOne),NumberConverter.convertToDouble(numTwo));
    }

    @RequestMapping(value="/sqrt/{numOne}", method=RequestMethod.GET)
    public Double sqrt(@PathVariable(value = "numOne") String numOne)
    throws Exception{
        if(!NumberConverter.isNumeric(numOne)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sqrt(NumberConverter.convertToDouble(numOne));
    }
}
