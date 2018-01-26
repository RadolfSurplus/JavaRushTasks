package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> result = new ArrayList<String>();
        while (tokenizer.hasMoreTokens()) {
            String input = tokenizer.nextToken();
            result.add(input);
        }
        return result.toArray(new String[result.size()]);
    }
}
