package com.juc.masterworker;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Task<R> {

    static AtomicInteger index = new AtomicInteger(1);

    public Consumer<Task<R>> resultAction;

    private int id;

    private int workerId;

    R result = null;

    public Task(){
        this.id = index.getAndIncrement();
    }

    public void execute(){
        this.result = this.doExecute();
        resultAction.accept(this);
    }

    protected R doExecute(){
        return null;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getId() {
        return id;
    }


    public R getResult() {
        return result;
    }
}
