package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input_file = new FileInputStream(reader.readLine());
        reader.close();
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        while (input_file.available() > 0) {
            int input = input_file.read();
            if (result.containsKey(input))
                result.put(input, result.get(input) + 1);
            else
                result.put(input, 1);
        }
        input_file.close();
        for (HashMap.Entry<Integer, Integer> out : result.entrySet()) {
            if (out.getValue() == Collections.max(result.values()))
                System.out.print(out.getKey() + " ");
        }
    }
}
