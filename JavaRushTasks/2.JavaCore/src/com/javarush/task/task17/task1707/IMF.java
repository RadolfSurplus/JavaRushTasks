package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf;
    private static boolean get = false;

    public static IMF getFund() {
        //add your code here - добавь код тут
        synchronized (IMF.class) {
            if (get) {
                imf = new IMF();
                get = !get;
            }
        }
        return imf;
    }

    private IMF() {
    }
}
