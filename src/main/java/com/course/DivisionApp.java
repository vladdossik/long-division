package com.course;


import com.course.formatters.Formatter;
import com.course.formatters.FormatterFactory;
import com.course.model.Result;

public class DivisionApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Result result = calculator.divide(134565, -13);
        Formatter formatter = FormatterFactory.getInstance().get("german");
        System.out.println(formatter.format(result));
    }
}
