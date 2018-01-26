package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String s;

        while (true) {
            s = r.readLine();
            if (s.equals("exit"))
                break;
            new ReadThread(s).start();
        }
    }

    public static class ReadThread extends Thread {
        private String nameOfFile;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.nameOfFile = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                FileInputStream f = new FileInputStream(nameOfFile);
                ArrayList<Integer> b = new ArrayList<>();

                while (f.available() > 0) {
                    int data = f.read();
                    b.add(data);
                }

                int max = Integer.MIN_VALUE;
                for (int i = 0; i < b.size(); i++) {
                    if (max < Collections.frequency(b, b.get(i))) {
                        max = Collections.frequency(b, b.get(i));
                        resultMap.put(nameOfFile, b.get(i));
                    }
                }

                f.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
