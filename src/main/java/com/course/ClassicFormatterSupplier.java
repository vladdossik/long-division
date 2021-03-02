package com.course;

import java.util.function.Supplier;


public class ClassicFormatterSupplier implements FormatterSupplier {

    @Override
    public String getName() {
        return "classic";
    }

    @Override
    public Formatter get() {
       return new ClassicFormatter();
    }
}
