package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader input = new FileReader(reader.readLine());
        FileWriter output = new FileWriter(reader.readLine());
        int i = 1;
        while (input.ready()) {
            int data = input.read();
            if (i % 2 == 0)
                output.write(data);
            i++;
        }
        input.close();
        output.close();
        reader.close();
    }
}
