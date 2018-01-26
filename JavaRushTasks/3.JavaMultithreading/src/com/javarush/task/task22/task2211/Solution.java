package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream(args[0]);
        FileOutputStream writer = new FileOutputStream(args[1]);
        while (input.available() > 0) {
            byte[] buffer = new byte[1000];
            input.read(buffer);
            String result = new String(buffer, "Windows-1251");
            buffer = result.getBytes("UTF-8");
            writer.write(buffer);
        }
        input.close();
        writer.close();
    }
}
