package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream input_file = new FileInputStream(args[0]);
        byte[] buffer = new byte[input_file.available()];
        input_file.read(buffer);
        input_file.close();
        TreeMap<Character, Integer> result = new TreeMap<Character, Integer>();
        char[] comparision = new String(buffer).toCharArray();
        for (int i = 0; i < comparision.length; i++) {
            if (result.containsKey(comparision[i]))
                result.put(comparision[i], result.get(comparision[i]) + 1);
            else
                result.put(comparision[i], 1);
        }
        for (Map.Entry<Character, Integer> map : result.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }
}
