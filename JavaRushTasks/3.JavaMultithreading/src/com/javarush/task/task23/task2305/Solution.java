package com.javarush.task.task23.task2305;

/*
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];
        for (int i = 0; i < 2; i++) {
            Solution solution = new Solution();
            for (int j = 0; j < 2; j++) {
                solution.innerClasses[j] = new InnerClass();
            }
            result[i] = solution;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
