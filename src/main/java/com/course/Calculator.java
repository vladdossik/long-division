package com.course;

import com.course.model.Pair;
import com.course.model.Result;

import java.util.ArrayList;

public class Calculator {
    public Result divide(int dividend, int divisor) {
        ArrayList<Pair> steps = new ArrayList<>() {
        };//for steps of division
        int tempDividend = Math.abs(dividend);
        int count = 0;
        int reminder = 0;
        int tempDivisor = divisor;
        divisor = Math.abs(divisor);
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0");
        }
        if (tempDividend >= divisor) {
            while (tempDividend > 0) {
                count++;
                tempDividend /= 10;
            }
            tempDividend = Math.abs(dividend);
            int[] digitsDividend = new int[count];
            for (int i = count - 1; i >= 0; i--) {
                digitsDividend[i] = tempDividend % 10;
                tempDividend /= 10;
            }
            reminder = digitsDividend[0];
            for (int i = 0; i < digitsDividend.length; i++) {
                if (reminder >= divisor) {
                    steps.add(new Pair(reminder, reminder / divisor * divisor));
                    reminder -= reminder / divisor * divisor;
                }
                if (reminder < divisor) {
                    try {
                        reminder = reminder * 10 + digitsDividend[i + 1];
                    } catch (Exception ignored) {
                    }
                }
            }
        } else {
            steps.add(new Pair(dividend, dividend));
        }
        return new Result(dividend, tempDivisor, dividend / tempDivisor, reminder, steps);
    }
}
