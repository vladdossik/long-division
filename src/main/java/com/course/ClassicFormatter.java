package com.course;

import java.util.List;

public class ClassicFormatter implements Formatter {
    @Override
    public String format(Result result) {
        List<Pair> steps = result.getPair();
        StringBuilder stringBuilder = new StringBuilder();
        int count = String.valueOf(steps.get(0).getSecond()).length();
        int countZero = 0;
        int firstIndent = 0;
        if (!String.valueOf(result.getDividend()).contains(String.valueOf(steps.get(0).getSecond())) || String.valueOf(result.getDividend()).contains(String.valueOf('-'))) {
            firstIndent++;
        }
        stringBuilder.append("\n" + "_").append(result.getDividend()).append("|").append(result.getDivisor()).append("\n").append(" ").append(repeatingCharacter(' ', firstIndent)).append(steps.get(0).getSecond()).append(repeatingCharacter(' ', String.valueOf(result.getDividend()).length() - count - firstIndent)).append("|").append(repeatingCharacter('-', String.valueOf(result.getQuotient()).length())).append("\n").append(repeatingCharacter(' ', 1 + firstIndent)).append(repeatingCharacter('_', count)).append(repeatingCharacter(' ', String.valueOf(result.getDividend()).length() - count - firstIndent)).append("|").append(result.getQuotient()).append("\n");
        char[] tempDividend = String.valueOf(result.getDividend()).toCharArray();
        for (int i = 0; i < String.valueOf(result.getDividend()).length(); i++) {
            if (tempDividend[i] == '0') countZero++;
        }
        count = firstIndent;
        for (int i = 1; i < steps.size(); i++) {
            if ((steps.get(i - 1).getFirst() - (steps.get(i - 1).getSecond())) == 0 && String.valueOf(steps.get(i - 1).getSecond()).length() >= 2) {
                count += String.valueOf(steps.get(i).getSecond()).length();
            }
            if (String.valueOf(result.getDividend()).contains(String.valueOf(steps.get(i).getSecond())) && countZero > 0 && count + 1 + countZero < String.valueOf(result.getDividend()).length()) {
                count += countZero;
            }
            stringBuilder.append(repeatingCharacter(' ', count)).append("_").append(steps.get(i).getFirst()).append("\n").append(repeatingCharacter(' ', count + 1)).append(steps.get(i).getSecond()).append("\n").append(repeatingCharacter(' ', count + 1)).append(repeatingCharacter('_', String.valueOf(steps.get(i).getSecond()).length())).append("\n");
            count++;
        }
        stringBuilder.append(repeatingCharacter(' ', count + 1)).append(result.getReminder()).append("\n");
        return stringBuilder.toString();
    }

    public String repeatingCharacter(char c, int amount) {
        return String.valueOf(c).repeat(Math.max(0, amount));
    }
}