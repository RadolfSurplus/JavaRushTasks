package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());
        if (first <= 0 || second <= 0) { throw new Exception();}
        if (first <= second)
            System.out.println(Search(second, first));
        else
            System.out.println(Search(first, second));
    }

    static int Search(int more, int less) {
        int result = 1;
        for (int i = 1; i <= less; i++) {
            if ((more % i == 0)&&(less % i == 0))
                result = i;
        }
        return result;
    }
}
