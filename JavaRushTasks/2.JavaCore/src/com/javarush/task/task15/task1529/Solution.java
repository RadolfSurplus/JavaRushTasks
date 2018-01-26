package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String type = reader.readLine();
            switch (type) {
                case "plane":
                    result = new Plane(Integer.parseInt(reader.readLine()));
                    break;
                case "helicopter":
                    result = new Helicopter();
                    break;
            }
            reader.close();
        }
        catch (IOException exception) {

        }
    }
}
