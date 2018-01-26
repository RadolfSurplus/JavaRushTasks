package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input_file = new FileInputStream(reader.readLine());
        FileOutputStream output_file = new FileOutputStream(reader.readLine());
        byte[] result = new byte[input_file.available()];
        input_file.read(result);
        for (int i = result.length - 1; i >= 0; i--) {
            output_file.write(result[i]);
        }
        reader.close();
        input_file.close();
        output_file.close();
    }
}
