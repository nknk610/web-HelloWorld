package com.example.demo.Calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements CalculatorService{
    @Override
    public int Calculate(String num1, String num2, String sign)
    {
        int result = 0, value1 = 0, value2 = 0;

        try
        {
            value1 = Integer.parseInt(num1);
            value2 = Integer.parseInt(num2);
        }
        catch(NumberFormatException ex)
        {
            throw ex;
        }
        
        switch(sign)
        {
            case "plus" :
                result = value1 + value2;
                break;
            case "minus" :
                result = value1 - value2;
                break;
            case "multi" :
                result = value1 * value2;
                break;
            case "divide" :
                try
                {
                    result = value1 / value2;
                }
                catch(ArithmeticException ex)
                {
                    throw ex;
                }

                break;
        }

        return result;
    }
}