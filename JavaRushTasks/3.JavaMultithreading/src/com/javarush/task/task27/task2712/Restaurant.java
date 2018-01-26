package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Cook firstCook = new Cook("Amigo");
        Waiter firstWaiter = new Waiter();
        Tablet tablet = new Tablet(5);
        tablet.addObserver(firstCook);
        firstCook.addObserver(firstWaiter);
        tablet.createOrder();
    }
}
