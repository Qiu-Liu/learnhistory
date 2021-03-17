package com.example.consul_demo.example;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线线程池
 */
public class TreadPoolExecutorDemo {

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();

        /**
         * corePoolSize 核心线程数
         * maximumPoolSize 最大线程数数
         *
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 30, TimeUnit.SECONDS, linkedBlockingQueue);

    }
}
