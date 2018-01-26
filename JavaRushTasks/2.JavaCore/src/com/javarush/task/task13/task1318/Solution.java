package com.javarush.task.task13.task1318;

import java.io.*;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        reader.close();
        InputStream inStream = new FileInputStream(fName);
        while (inStream.available() > 0) {
            int data = inStream.read();
            System.out.print((char)data);
        }
        inStream.close();
    }
}