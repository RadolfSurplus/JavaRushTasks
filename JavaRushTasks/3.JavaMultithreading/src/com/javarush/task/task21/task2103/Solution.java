package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
       // return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        return c;

        /* (a * b * c * ^d) + (^a * c) + (^b * c) + (c * d) = c * (a * b * ^d + ^a + ^b + d);
            По распределительному закону: a * b * ^d + ^a = (a + ^a) * (b * ^d + ^a) = b * ^d + ^a
            Следовательно: c * (a * b * ^d + ^a + ^b + d) = c * (b * ^d + ^a + ^b + d)
            По распределительному закону: b * ^d + ^b = (b + ^b)*(^b + ^d) = ^b + ^d
            Следовательно: c * (b * ^d + ^a + ^b + d) = c * (^a + d + ^b + ^d) = c * (1 + ^a + ^b) = c
            Ответ: с */
    }

    public static void main(String[] args) {

    }
}
