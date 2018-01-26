package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader first_file = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader second_file = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        ArrayList<String> first_input = new ArrayList<String>();
        ArrayList<String> second_input = new ArrayList<String>();
        while (first_file.ready()) {
            first_input.add(first_file.readLine());
        }
        first_file.close();
        while (second_file.ready()) {
            second_input.add(second_file.readLine());
        }
        second_file.close();
        while (first_input.size() > 0 && second_input.size() > 0) {
            if (first_input.get(0).equals(second_input.get(0))) {
                if (lines.size() > 0) {
                    if (lines.get(lines.size() - 1).type == Type.ADDED || lines.get(lines.size() - 1).type == Type.REMOVED) {
                        lines.add(new LineItem(Type.SAME, second_input.get(0)));
                        first_input.remove(0);
                        second_input.remove(0);
                    }
                } else {
                    lines.add(new LineItem(Type.SAME, first_input.get(0)));
                    first_input.remove(0);
                    second_input.remove(0);
                }
            }
            if (first_input.get(0).equals(" ")) {
                if (lines.size() > 0) {
                    if (lines.get(lines.size() - 1).type == Type.ADDED || lines.get(lines.size() - 1).type == Type.REMOVED) {
                        lines.add(new LineItem(Type.SAME, second_input.get(0)));
                        first_input.remove(0);
                        second_input.remove(0);
                    }
                } else {
                    lines.add(new LineItem(Type.ADDED, first_input.get(0)));
                    first_input.remove(0);
                    second_input.remove(0);
                }
            }
            if (second_input.get(0).equals(" ")) {
                if (lines.size() > 0) {
                    if (lines.get(lines.size() - 1).type == Type.ADDED || lines.get(lines.size() - 1).type == Type.REMOVED) {
                        lines.add(new LineItem(Type.SAME, second_input.get(0)));
                        first_input.remove(0);
                        second_input.remove(0);
                    }
                } else {
                    lines.add(new LineItem(Type.REMOVED, first_input.get(0)));
                    first_input.remove(0);
                    second_input.remove(0);
                }
            }
        }
        if (first_input.size() == 0)
            lines.add(new LineItem(Type.REMOVED, second_input.get(0)));
        else
            lines.add(new LineItem(Type.ADDED, first_input.get(0)));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
