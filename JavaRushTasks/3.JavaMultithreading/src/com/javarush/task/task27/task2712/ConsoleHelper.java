package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage("Список блюд: ");
        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите блюдо. Введите 'exit' для выхода.");
        String customerChoose;
        List<Dish> resultList = new LinkedList<Dish>();
        while (true) {
            customerChoose = readString();
            if (customerChoose.isEmpty()) {
                writeMessage("Блюдо не выбрано.");
                continue;
            }
            if (customerChoose.equalsIgnoreCase("exit"))
                break;
            try {
                resultList.add(Dish.valueOf(customerChoose));
            } catch (IllegalArgumentException exc) {
                writeMessage("Выбранное блюдо отсутствует. Повторите ввод.");
            }
        }
        return resultList;
    }
}
