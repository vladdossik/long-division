package com.course;

import java.util.Scanner;

public class DivisionApp {
    public static void main(String[]args){
        Calculator calculator=new Calculator();
        Result result=calculator.divide(1,0);
        Formatter formatter=FormatterFactory.getInstance().get("classic");
        String output=formatter.format(result);
        System.out.println(output);
    }
}
