package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        t1.start();
        t1.join();
        Read3Strings t2 = new Read3Strings();
        t2.start();
        t2.join();

        //add your code here - добавьте код тут

        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        String result = "";
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    result += reader.readLine() + " ";
                }
            }
            catch (Exception e) {

            }
        }

        public void printResult() {
            System.out.println(result);
        }
    }
}
