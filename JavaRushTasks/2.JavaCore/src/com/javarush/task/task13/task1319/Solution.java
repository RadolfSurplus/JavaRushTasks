package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        String inString;
        do {
            inString = reader.readLine();
            writer.write(inString);
            writer.newLine();
        } while (!inString.equals("exit"));
        writer.close();
        reader.close();
    }
}
