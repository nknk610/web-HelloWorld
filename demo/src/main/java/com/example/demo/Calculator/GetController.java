package com.example.demo.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
    @Autowired
    private CalculatorService calculator;
    
    @GetMapping("calculator/{num1}/{num2}/{sign}")
    public String calculate(@PathVariable String num1, @PathVariable String num2, @PathVariable String sign)
    {
        String result;

        try
        {
            result = String.valueOf(calculator.Calculate(num1, num2, sign));
        }
        catch(ArithmeticException ex)
        {
            result = "0으로 나눌 수 없습니다.";
        }
        catch(NumberFormatException ex)
        {
            result = "숫자를 입력하세요";    
        }

        return result;
        
    }
}