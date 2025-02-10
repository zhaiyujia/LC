package com.juc.masterworker;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MasterWorkerTest {

    static class SimpleTask extends Task<Integer> {
        @Override
        protected Integer doExecute() {
            System.out.println("task " + getId() + " is done ");
            return getId();
        }

    }

    public static void main(String[] args) {
        //创建Master，包含4个Worker，并启动Master的执行线程
        Master<SimpleTask, Integer> master = new Master<>(4);
        //定期向Master提交任务
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> master.submit(new SimpleTask()),
                2,1, TimeUnit.SECONDS);
        //定期从Master提取结果
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
        newScheduledThreadPool.scheduleAtFixedRate(() -> master.printResult(), 5, 1, TimeUnit.SECONDS);
    }


}
