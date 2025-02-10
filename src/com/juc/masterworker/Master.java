package com.juc.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class Master<T extends Task, R> {

    private HashMap<String, Worker<T, R>> workers = new HashMap<>();

    private LinkedBlockingQueue<T> taskQueue = new LinkedBlockingQueue<>();

    private Map<String, R> resultMap = new ConcurrentHashMap<>();

    private Thread thread = null;

    private AtomicLong sum = new AtomicLong();

    public Master(int workerCount) {
        for (int i = 0; i < workerCount; i++) {
            Worker<T, R> worker = new Worker<>();
            workers.put("子节点：" + i, worker);
        }
        thread = new Thread(() -> this.execute());
        thread.start();
    }

    public void submit(T task) {
        taskQueue.add(task);
    }

    private void resultCallBack(Object o) {
        Task<R> task = (Task<R>) o;
        String taskName = "Worker:" + task.getWorkerId() + "-" + "Task:" + task.getId();
        R result = task.getResult();
        resultMap.put(taskName, result);
        sum.getAndAdd((Integer) result);
    }


    public void execute() {
        for (; ; ) {
            for (Map.Entry<String, Worker<T, R>> entry : workers.entrySet()) {
                T task = null;
                try {
                    task = this.taskQueue.take();
                    Worker worker = entry.getValue();
                    worker.submit(task, this::resultCallBack);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printResult() {
        System.out.println("----------sum is :" + sum.get());
        for (Map.Entry<String, R> entry : resultMap.entrySet()) {
            String taskName = entry.getKey();
            System.out.println(taskName + ":" + entry.getValue());
        }
    }


}
