package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream first_file = new FileOutputStream(reader.readLine());
        FileInputStream second_file = new FileInputStream(reader.readLine());
        FileInputStream third_file = new FileInputStream(reader.readLine());
        while (second_file.available() > 0) {
            first_file.write(second_file.read());
        }
        second_file.close();
        while (third_file.available() > 0) {
            first_file.write(third_file.read());
        }
        third_file.close();
        first_file.close();
    }
}
