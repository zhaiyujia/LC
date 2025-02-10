package com.juc.masterworker;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Worker<T extends Task, R> {

    private LinkedBlockingQueue<T> taskQueue = new LinkedBlockingQueue<>();

    static AtomicInteger index = new AtomicInteger(1);

    private int workerId;

    private Thread thread = null;

    public Worker() {
        this.workerId = index.getAndIncrement();
        thread = new Thread(() -> this.run());
        thread.start();
    }


    public void run() {
        for (; ; ) {
            try {
                T task = this.taskQueue.take();
                task.setWorkerId(workerId);
                task.execute();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void submit(T task, Consumer<R> action) {
        task.resultAction = action;
        try {
            this.taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
