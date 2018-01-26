package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    int count = 3;
    String country = "Ukraine";
    @Override
    int getCountOfEggsPerMonth() {
        return count;
    }

    @Override
    String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + count + " яиц в месяц.");
    }
}
