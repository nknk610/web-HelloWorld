package com.example.demo.Calculator;

public interface CalculatorService {
    int Calculate(String num1, String num2, String sign) throws ArithmeticException, NumberFormatException;
}