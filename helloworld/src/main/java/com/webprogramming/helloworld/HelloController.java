package com.webprogramming.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController 
{
    @GetMapping("/add")
    public String Add(@RequestParam final String param1, @RequestParam final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e){ return "숫자가 입력되지 않았습니다.";}

        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @GetMapping("/sub")
    public String Subtract(@RequestParam final String param1, @RequestParam final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e){ return "숫자가 입력되지 않았습니다.";}

        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @GetMapping("/mul")
    public String Multiply(@RequestParam final String param1, @RequestParam final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e){ return "숫자가 입력되지 않았습니다.";}

        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @GetMapping("/div")
    public String Divide(@RequestParam final String param1, @RequestParam final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e) {return "숫자가 입력되지 않았습니다.";}

        if (num2 == 0f) return "0으로 나눌 수 없습니다";
        return num1 + " / " + num2 + " = " + (num1 / num2);
    }

    @GetMapping("/add1/{param1}/{param2}")
    public String Add1(@PathVariable final String param1, @PathVariable final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e){ return "숫자가 입력되지 않았습니다.";}

        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @GetMapping("/sub1/{param1}/{param2}")
    public String Subtract1(@PathVariable final String param1, @PathVariable final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e){ return "숫자가 입력되지 않았습니다.";}

        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @GetMapping("/mul1/{param1}/{param2}")
    public String Multiply1(@PathVariable final String param1, @PathVariable final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e){ return "숫자가 입력되지 않았습니다.";}

        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @GetMapping("/div1/{param1}/{param2}")
    public String Divide1(@PathVariable final String param1, @PathVariable final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e) {return "숫자가 입력되지 않았습니다.";}

        if (num2 == 0f) return "0으로 나눌 수 없습니다";
        return num1 + " / " + num2 + " = " + (num1 / num2);
    }

    @PostMapping("/add2")
    public String Add2(@RequestParam final String param1, @RequestParam final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e){ return "숫자가 입력되지 않았습니다.";}

        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @GetMapping("/sub2")
    public String Subtract2(@RequestParam final String param1, @RequestParam final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e){ return "숫자가 입력되지 않았습니다.";}

        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @GetMapping("/mul2")
    public String Multiply2(@RequestParam final String param1, @RequestParam final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e){ return "숫자가 입력되지 않았습니다.";}

        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @GetMapping("/div2")
    public String Divide2(@RequestParam final String param1, @RequestParam final String param2)
    {
        float num1 = 0f, num2 = 0f;
        try
        {
            num1 = Float.parseFloat(param1);
            num2 = Float.parseFloat(param2);
        } catch(NumberFormatException e) { return "숫자가 입력되지 않았습니다.";}

        if (num2 == 0f) return "0으로 나눌 수 없습니다";
        return num1 + " / " + num2 + " = " + (num1 / num2);
    }
}