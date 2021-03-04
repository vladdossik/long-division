package com.course;

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
