package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
            uncaughtException(t, e.getCause());
            System.out.println(e);
        }
        catch (NullPointerException ex) {
            t.interrupt();
        }
    }

    public static void main(String[] args) {
    }
}
