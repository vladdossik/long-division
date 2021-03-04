package com.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Result {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int reminder;
    private List<Pair> steps = new ArrayList<>();

    public Result(int dividend, int divisor, int quotient, int reminder, List<Pair> steps) {
        this.dividend = dividend;//делимое
        this.divisor = divisor;//делитель
        this.quotient = quotient;//частное
        this.reminder = reminder;//остаток
        this.steps = steps;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getReminder() {
        return reminder;
    }

    public List<Pair> getPair() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return dividend == result.dividend && divisor == result.divisor && quotient == result.quotient
                && reminder == result.reminder && steps.containsAll(result.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, quotient, reminder, steps);
    }
}
