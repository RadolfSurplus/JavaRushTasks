package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input_file = new FileInputStream(reader.readLine());
        FileOutputStream first_out_file = new FileOutputStream(reader.readLine());
        FileOutputStream second_out_file = new FileOutputStream(reader.readLine());
        int count = 0;
        if (input_file.available() % 2 != 0)
            count = input_file.available() / 2 + 1;
        else
            count = input_file.available() / 2;
        byte[] result = new byte[count];
        byte[] result_second = new byte[count];
        while (input_file.available() > 0) {
            int input = input_file.read(result);
            first_out_file.write(result, 0, input);
            input = input_file.read(result_second);
            second_out_file.write(result_second, 0, input);
        }
        input_file.close();
        first_out_file.close();
        second_out_file.close();
    }
}
