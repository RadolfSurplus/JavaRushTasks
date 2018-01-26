package com.javarush.task.task14.task1408;

public class RussianHen extends Hen{
    int count = 4;
    String country = "Russia";
    @Override
    int getCountOfEggsPerMonth() {
        return count;
    }

    @Override
    String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + count + " яиц в месяц.");
    }
}
