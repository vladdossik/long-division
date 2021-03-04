package com.course;

import java.util.Objects;

public class Pair {
    private final int firstNumber;
    private final int secondNumber;

    public Pair(int first, int second) {
        firstNumber = first;
        secondNumber = second;
    }

    public int getFirst() {
        return firstNumber;
    }

    public int getSecond() {
        return secondNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return firstNumber == pair.firstNumber && secondNumber == pair.secondNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber);
    }
}
