package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input_file = new FileInputStream(reader.readLine());
        reader.close();
        int min = Integer.MAX_VALUE;
        while (input_file.available() > 0) {
            int input = input_file.read();
            if (input < min)
                min = input;
        }
        input_file.close();
        System.out.println(min);
    }
}
