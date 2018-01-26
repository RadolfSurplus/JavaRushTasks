package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input_stream = new FileInputStream(reader.readLine());
        int max = Byte.MIN_VALUE;
        while (input_stream.available() > 0) {
            int input = input_stream.read();
            if (input > max)
                max = input;
        }
        reader.close();
        input_stream.close();
        System.out.println(max);
    }
}
