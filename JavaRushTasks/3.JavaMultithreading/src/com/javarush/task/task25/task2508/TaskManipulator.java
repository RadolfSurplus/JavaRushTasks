package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                System.out.println(thread.currentThread().getName());
                Thread.sleep(100);
            }
        }
        catch (Exception exc) {}
    }

    @Override
    public void start(String threadName) {
        Thread thread = new Thread(this, threadName);
        this.thread = thread;
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
