package com.course.model;

import com.course.formatters.Formatter;
import com.course.formatters.FormatterSupplier;

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
