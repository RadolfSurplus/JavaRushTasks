package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;
    private State current;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        refreshState();
    }

    public void run() {
        while (current != State.TERMINATED) {
            refreshState();
        }

    }

    public void refreshState() {
        if (current != thread.getState()) {
            current = thread.getState();
            System.out.println(current);
        }
    }
}
