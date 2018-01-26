package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file_input = new FileInputStream(reader.readLine());
        reader.close();
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        while (file_input.available() > 0) {
            int input = file_input.read();
            if (result.containsKey(input))
                result.put(input, result.get(input) + 1);
            else
                result.put(input, 1);
        }
        file_input.close();
        for (HashMap.Entry<Integer, Integer> output : result.entrySet()) {
            if (output.getValue() == 1)
                System.out.print(output.getKey() + " ");
        }
    }
}
