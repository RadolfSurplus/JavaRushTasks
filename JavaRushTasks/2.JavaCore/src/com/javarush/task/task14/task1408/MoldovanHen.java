package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{
    int count = 2;
    String country = "Moldova";
    @Override
    int getCountOfEggsPerMonth() {
        return count;
    }

    @Override
    String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + count + " яиц в месяц.");
    }
}
