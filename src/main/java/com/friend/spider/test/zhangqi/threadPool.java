package com.friend.spider.test.zhangqi;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class threadPool {

    private static int minPoolSize = 10;
    private static int maxPoolSize = 10;

    public static final ThreadPoolExecutor executor = new ThreadPoolExecutor(minPoolSize, maxPoolSize, 10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());
}
