package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    int count = 1;
    @Override
    int getCountOfEggsPerMonth() {
        return count;
    }

    @Override
    String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + count + " яиц в месяц.");
    }
}
