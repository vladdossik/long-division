package com.course;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int reminder;
    private final ArrayList<Pair> steps;
    public Result(int dividend, int divisor, int quotient, int reminder, ArrayList<Pair> steps){
        this.dividend=dividend;//делимое
        this.divisor=divisor;//делитель
        this.quotient=quotient;//частное
        this.reminder=reminder;//остаток
        this.steps=steps;
    }
    public int getDividend(){
        return dividend;
    }
    public int getDivisor(){
        return divisor;
    }
    public int getQuotient(){
        return quotient;
    }
    public int getReminder(){
        return reminder;
    }
    public ArrayList<Pair> getPair(){
        return steps;
    }
    @Override
    public boolean equals(Object o){
        Result result=(Result)o;
        return dividend== result.dividend&&
                divisor==result.divisor&&
                quotient==result.quotient&&
                reminder==result.reminder;
    }
}
