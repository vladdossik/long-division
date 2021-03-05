package com.course;

public class GermanFormatterSupplier implements FormatterSupplier {

    @Override
    public String getName() {
        return "german";
    }

    @Override
    public Formatter get() {
        return new GermanFormatter();
    }
}
