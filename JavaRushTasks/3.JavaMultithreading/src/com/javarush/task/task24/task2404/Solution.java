package com.javarush.task.task24.task2404;

/*
Рефакторинг Rectangle
*/
public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
       // System.out.println(castToHasHeight(rectangle));
        //System.out.println(castToHasWidth(rectangle));
        /////////////////////expected//////////////////
        System.out.println(rectangle.castToHasHeight());
        System.out.println(rectangle.castToHasWidth());
    }


    public static class Rectangle {
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        public double getHeight() {
            return Math.abs(point1.getY() - point2.getY());
        }

        public HasHeight castToHasHeight() {
            return ()-> Math.abs(point1.getY() - point2.getY());
        }

        public HasWidth castToHasWidth() {
            return ()-> Math.abs(point1.getX() - point2.getX());
        }
    }
}
