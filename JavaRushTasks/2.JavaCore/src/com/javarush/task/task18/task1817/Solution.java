package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream input_file = new FileInputStream(args[0]);
        int space_count = 0;
        int available = input_file.available();
        while (input_file.available() > 0) {
            String input = "" + (char)input_file.read();
            if (input.equals(" "))
                space_count++;
        }
        input_file.close();
        System.out.printf("%.2f", (double)space_count / available * 100);
    }
}
