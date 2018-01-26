package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = reader.readLine();
        reader = new BufferedReader(new FileReader(file_name));
        String input = "";
        while (reader.ready()) {
            input = reader.readLine();
            if (input.startsWith(args[0]))
                System.out.println(input);
        }
        reader.close();
    }
}
