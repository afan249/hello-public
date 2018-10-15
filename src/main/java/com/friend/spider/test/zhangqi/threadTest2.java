package com.friend.spider.test.zhangqi;

/**
 * 线程方法的基本使用，生命周期的几个状态
 */

public class threadTest2 {


    public static void main(String[] args) {
         Thread t = new Thread(new Runnable() {
             @Override
             public void run() {
               System.out.println("hello");
             }
         });

        //线程从出生到---> 就绪状态
        //线程为可执行状态，只要得到系统资源后就为执行状态
        t.start();

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("word");
            }
        });

        t2.start();
      /*  //线程等待状态
        try {
            t.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //


    }
}
