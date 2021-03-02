package com.course;


import java.util.ArrayList;

public class ClassicFormatter implements Formatter {
    @Override
    public String format(Result result) {
        ArrayList<Pair> steps = result.getPair();
        StringBuilder stringBuilder = new StringBuilder();
        int count=String.valueOf(steps.get(0).getSecond()).length();
        stringBuilder.append("_" + result.getDividend() + "|" + result.getDivisor() + "\n" +
        " "+steps.get(0).getSecond()+
        repeatingCharacter(' ',String.valueOf(result.getDividend()).length()-count)+"|"+
        repeatingCharacter('-',String.valueOf(result.getQuotient()).length())+"\n"+
        " "+repeatingCharacter('_',count)+
        repeatingCharacter(' ',String.valueOf(result.getDividend()).length()-count)+"|"+
        result.getQuotient()+"\n");
        count=0;
        for(int i=1;i<steps.size();i++){
            if(String.valueOf(result.getDividend()).contains(String.valueOf(steps.get(i).getFirst()))&&count<String.valueOf(result.getDividend()).length()){
                if(count+String.valueOf(result.getDividend()).length()-String.valueOf(steps.get(i).getFirst()).length()>String.valueOf(result.getDividend()).length()){
                    continue;
                }else count+=String.valueOf(result.getDividend()).length()-String.valueOf(steps.get(i).getFirst()).length();
            }
            stringBuilder.append(repeatingCharacter(' ',count)+"_"+steps.get(i).getFirst()+"\n"+
            repeatingCharacter(' ',count+1)+steps.get(i).getSecond()+"\n"+
             repeatingCharacter(' ',count+1)+repeatingCharacter('_',String.valueOf(steps.get(i).getSecond()).length())+"\n");
            count++;
        }
        stringBuilder.append(repeatingCharacter(' ',count+1)+result.getReminder());
        return stringBuilder.toString();
    }
    public String repeatingCharacter(char c, int amount) {
        String repeat = "";
        for (int i = 0; i < amount; i++) {
            repeat += c;
        }
        return repeat;
    }
}