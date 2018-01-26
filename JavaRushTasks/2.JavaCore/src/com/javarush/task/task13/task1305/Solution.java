package com.javarush.task.task13.task1305;

/* 
Четыре ошибки
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        System.out.println(Dream.HOBBIE.toString());
        System.out.println(new Hobbie());

    }

    interface Desire {
    }

    interface Dream {
        public Hobbie HOBBIE = new Hobbie();
    }

    static class Hobbie implements Desire, Dream {
        public int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }

}
