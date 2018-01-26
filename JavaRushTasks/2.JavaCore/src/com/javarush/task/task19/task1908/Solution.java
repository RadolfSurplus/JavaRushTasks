package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input_file_name = reader.readLine();
        String output_file_name = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(input_file_name));
        BufferedWriter writer = new BufferedWriter(new FileWriter(output_file_name));
        Pattern pat = Pattern.compile("\\b\\d+\\b"); //поиск целых чисел
        String input = null;
        while (reader.ready()) {
            input = reader.readLine();
            Matcher mat = pat.matcher(input);
            while (mat.find()) {
                writer.write(mat.group() + " ");
            }
        }
        reader.close();
        writer.close();
    }
}
