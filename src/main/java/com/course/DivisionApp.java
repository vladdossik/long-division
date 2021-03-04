package com.course;


public class DivisionApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Result result = calculator.divide(134565, -13);
        Formatter formatter = FormatterFactory.getInstance().get("classic");
        System.out.println(formatter.format(result));
    }
}
