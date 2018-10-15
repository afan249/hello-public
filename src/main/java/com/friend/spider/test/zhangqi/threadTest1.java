package com.friend.spider.test.zhangqi;

/**
 * 线程的创建 使用实现Runnable接口
 */

public class threadTest1 implements  Runnable {

    @Override
    public void run() {
      System.out.println("Hello,word");
    }

    public static void main(String[] args) {
           threadTest1 threadTest1 = new threadTest1();
           Thread threadA = new Thread(threadTest1,"线程A");
           threadA.start();
           threadA.getName();
           System.out.println("子线程的名称:"+threadA.getName());
    }

}
