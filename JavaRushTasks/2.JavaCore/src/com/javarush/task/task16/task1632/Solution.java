package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new MyThreads("Thread#1")));
        threads.add(new Thread(new MyThreads("Thread#2")));
        threads.add(new Thread(new MyThreads("Thread#3")));
        threads.add(new MyThread4());
        threads.add(new Thread(new MyThreads("Thread#5")));
    }

    public static void main(String[] args) {
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();
    }

    public static class MyThreads extends Thread {
        public String name;
        public static boolean stop = false;

        public MyThreads(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            //1
            if (this.name.equals("Thread#1")) {
                while (true) {
                }
            }
            //2
            if (this.name.equals("Thread#2")) {
                try {
                    while (true) {
                        throw new InterruptedException();
                    }
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
            //3
            if (this.name.equals("Thread#3")) {
                while (!stop) {
                    System.out.println("Ура");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
            //5
            if (this.name.equals("Thread#5")) {
                Scanner in = new Scanner(System.in);
                int sum = 0;
                while (!stop) {
                    if (in.hasNextInt()) {
                        sum += in.nextInt();
                    } else if (in.hasNext() && in.next().equals("N")) {
                        System.out.println(sum);
                        stop = true;
                    }
                }
            }
        }
    }

    public static class MyThread4 extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
        }

        @Override
        public void run() {
            super.run();
            if (Thread.currentThread().isAlive()) {
                showWarning();
            }
        }
    }
}