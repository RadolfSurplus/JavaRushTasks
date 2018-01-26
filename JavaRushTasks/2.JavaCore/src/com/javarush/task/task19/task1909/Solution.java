package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input_reader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter output_writer = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        while (input_reader.ready()) {
            output_writer.write(input_reader.readLine().replaceAll("\\.", "!"));
        }
        input_reader.close();
        output_writer.close();
    }
}
