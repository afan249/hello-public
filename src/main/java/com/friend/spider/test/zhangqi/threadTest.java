package com.friend.spider.test.zhangqi;

/**
 * 线程的创建 继承Thread
 */

public class threadTest extends Thread {

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Hello World");
        }
    }

    public void run(){
        System.out.println("Hello World");
    }

    public static void main(String args[]){
        threadPool.executor.execute(new Task());
       // new Thread(new Task()).start();
    }

}
