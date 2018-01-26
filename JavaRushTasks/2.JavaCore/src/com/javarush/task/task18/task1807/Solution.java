package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input_file = new FileInputStream(reader.readLine());
        int count = 0;
        while (input_file.available() > 0) {
            char input = (char) input_file.read();
            if (input == ',')
                count++;
        }
        reader.close();
        input_file.close();
        System.out.println(count);
    }
}
