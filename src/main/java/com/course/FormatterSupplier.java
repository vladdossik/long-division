package com.course;

import java.util.function.Supplier;

public interface FormatterSupplier extends Supplier<Formatter> {
    String getName();
}
