package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader input_file = new FileReader(args[0]);
        String alphabet_input = "qwertyuiopasdfghjklzxcvbnm";
        int count = 0;
        while (input_file.ready()) {
            String input = "" + (char)input_file.read();
            if (alphabet_input.contains(input.toLowerCase()))
                count++;
        }
        input_file.close();
        System.out.println(count);
    }
}
