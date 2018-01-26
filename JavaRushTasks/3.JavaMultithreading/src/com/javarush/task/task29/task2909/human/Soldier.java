package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {
    private String name;
    private int age;

    public void fight() {
    }

    @Override
    public void live() {
        fight();
    }

    public Soldier(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }
}
