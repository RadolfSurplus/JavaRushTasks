package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file_input = new FileInputStream(reader.readLine());
        reader.close();
        TreeSet<Integer> result = new TreeSet<Integer>();
        while (file_input.available() > 0) {
            int input = file_input.read();
            result.add(input);
        }
        file_input.close();
        for (Integer output : result) {
            System.out.print(output + " ");
        }
    }
}
