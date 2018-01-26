package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> result = new TreeMap<String, Double>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String[] input = reader.readLine().split(" ");
            if (result.containsKey(input[0]))
                result.put(input[0], result.get(input[0]) + Double.parseDouble(input[1]));
            else
                result.put(input[0], Double.parseDouble(input[1]));
        }
        reader.close();
        LinkedList<String> key_out = new LinkedList<>();
        double max_value = Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getValue();
        for (Map.Entry<String, Double> map : result.entrySet()) {
            if (map.getValue() == max_value)
                System.out.println(map.getKey());
        }
    }
}
