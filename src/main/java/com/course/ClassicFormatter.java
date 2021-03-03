package com.course;


import java.util.ArrayList;

public class ClassicFormatter implements Formatter {
    @Override
    public String format(Result result) {
        ArrayList<Pair> steps = result.getPair();
        StringBuilder stringBuilder = new StringBuilder();
        int count=String.valueOf(steps.get(0).getSecond()).length();
        int countZero=0;
        int firstIndent=0;
        if(!String.valueOf(result.getDividend()).contains(String.valueOf(steps.get(0).getSecond()))||String.valueOf(result.getDividend()).contains(String.valueOf('-'))){
            firstIndent++;
        }

        stringBuilder.append("\n"+"_" + result.getDividend() + "|" + result.getDivisor() + "\n" +
                " "+repeatingCharacter(' ',firstIndent)+steps.get(0).getSecond()+
                repeatingCharacter(' ',String.valueOf(result.getDividend()).length()-count-firstIndent)+"|"+
                repeatingCharacter('-',String.valueOf(result.getQuotient()).length())+"\n"+
                repeatingCharacter(' ', 1+firstIndent)+repeatingCharacter('_',count)+
                repeatingCharacter(' ',String.valueOf(result.getDividend()).length()-count-firstIndent)+"|"+
                result.getQuotient()+"\n");
        count=0;
        char[]tempDividend=String.valueOf(result.getDividend()).toCharArray();
        for(int i=0;i<String.valueOf(result.getDividend()).length();i++){
            if(tempDividend[i]=='0')countZero++;
        }
        count=firstIndent;
        for(int i=1;i<steps.size();i++){
            if((steps.get(i-1).getFirst()-(steps.get(i-1).getSecond()))==0&&String.valueOf(steps.get(i-1).getSecond()).length()>=2)
            {
                count+=String.valueOf(steps.get(i).getSecond()).length();
            }
            if(String.valueOf(result.getDividend()).contains(String.valueOf(steps.get(i).getSecond()))&&countZero>0&&count+1+countZero<String.valueOf(result.getDividend()).length()){
                count+=countZero;
            }
            stringBuilder.append(repeatingCharacter(' ',count)+"_"+steps.get(i).getFirst()+"\n"+
                    repeatingCharacter(' ',count+1)+steps.get(i).getSecond()+"\n"+
                    repeatingCharacter(' ',count+1)+repeatingCharacter('_',String.valueOf(steps.get(i).getSecond()).length())+"\n");
            count++;
        }
        stringBuilder.append(repeatingCharacter(' ',count+1)+result.getReminder()+"\n");
        return stringBuilder.toString();
    }
    public String repeatingCharacter(char c, int amount) {
        StringBuilder repeat=new StringBuilder();
        for (int i = 0; i < amount; i++) {
            repeat.append(c);
        }
        return repeat.toString();
    }
}