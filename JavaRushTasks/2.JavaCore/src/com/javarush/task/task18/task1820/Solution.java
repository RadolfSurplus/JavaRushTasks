package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        FileInputStream input_file = new FileInputStream(first);
        FileOutputStream output_file = new FileOutputStream(second);
        reader.close();
        byte[] buffer = new byte[input_file.available()];
        input_file.read(buffer);
        String input = new String(buffer);
        for (String division : input.split(" ")) {
            output_file.write((Math.round(Float.parseFloat(division)) + " ").getBytes());
        }
        input_file.close();
        output_file.close();
    }
}
