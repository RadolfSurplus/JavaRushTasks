package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private static List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : game.horses) {
            horse.move();
        }

    }

    public void print() {
        for (Horse horse : game.horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        
    }

    public Horse getWinner() {
        return horses.stream().max((h1, h2) -> Double.compare(h1.getDistance(), h2.getDistance())).get();
    }

    public void printWinner() {
        System.out.printf("Winner is %s!%n",getWinner().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        Horse first_horse = new Horse("First", 3, 0);
        Horse second_horse = new Horse("Second", 3, 0);
        Horse third_horse = new Horse("Third", 3, 0);
        game.getHorses().add(first_horse);
        game.getHorses().add(second_horse);
        game.getHorses().add(third_horse);
        game.run();
        game.printWinner();
    }
}
