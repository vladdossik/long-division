package com.course.formatters;

import com.course.model.Pair;
import com.course.model.Result;

import java.util.List;

public class GermanFormatter implements Formatter {
    @Override
    public String format(Result result) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Pair> steps = result.getPair();
        int count = 0;
        int countZero = 0;
        if (String.valueOf(result.getDividend()).contains(String.valueOf('-'))) {
            count++;
        }
        stringBuilder.append("\n").append(result.getDividend()).append(" ÷ ").append(result.getDivisor()).append(" => ").append(result.getQuotient()).append("\n").append(repeatingCharacter(' ',count)).append(steps.get(0).getSecond()).append("\n").append(repeatingCharacter(' ',count)).append(repeatingCharacter('_',String.valueOf(steps.get(0).getSecond()).length())).append("\n");
        char[] tempDividend = String.valueOf(result.getDividend()).toCharArray();
        for (int i = 0; i < String.valueOf(result.getDividend()).length(); i++) {
            if (tempDividend[i] == '0') countZero++;
        }

        for (int i = 1; i < steps.size(); i++) {
            if ((steps.get(i - 1).getFirst() - (steps.get(i - 1).getSecond())) == 0 && String.valueOf(steps.get(i - 1).getSecond()).length() >= 2) {
                count += String.valueOf(steps.get(i).getSecond()).length();
            }
            if (String.valueOf(result.getDividend()).contains(String.valueOf(steps.get(i).getSecond())) && countZero > 0 && count + 1 + countZero < String.valueOf(result.getDividend()).length()) {
                count += countZero;
            }
            stringBuilder.append(repeatingCharacter(' ', count)).append(steps.get(i).getFirst()).append("\n").append(repeatingCharacter(' ', count)).append(steps.get(i).getSecond()).append("\n").append(repeatingCharacter(' ', count)).append(repeatingCharacter('_', String.valueOf(steps.get(i).getSecond()).length())).append("\n");
            count++;
        }
        stringBuilder.append(repeatingCharacter(' ', count)).append(result.getReminder()).append("\n");
        return stringBuilder.toString();
    }

    public String repeatingCharacter(char c, int amount) {
        return String.valueOf(c).repeat(Math.max(0, amount));
    }

}
