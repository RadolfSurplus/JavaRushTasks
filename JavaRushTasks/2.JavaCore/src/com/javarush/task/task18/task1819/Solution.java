package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first_file_name = reader.readLine();
        String second_file_name = reader.readLine();
        FileInputStream first_file = new FileInputStream(first_file_name);
        byte[] buffer = new byte[first_file.available()];
        first_file.read(buffer);
        first_file.close();
        FileOutputStream addition = new FileOutputStream(first_file_name);
        FileInputStream second_file = new FileInputStream(second_file_name);
        while (second_file.available() > 0) {
            addition.write(second_file.read());
        }
        addition.write(buffer);
        addition.close();
        second_file.close();
    }
}
