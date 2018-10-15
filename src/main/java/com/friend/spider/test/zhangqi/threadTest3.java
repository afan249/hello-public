package com.friend.spider.test.zhangqi;

public class threadTest3 implements  Runnable {

    int num = 10;
    boolean flag = true;
    @Override
    public void run() {
     while(flag){
       synchronized (this){

           if(num>0){
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("剩余火车票"+num--);
              Boolean tes = Thread.holdsLock(this);
              System.out.println("是否有锁"+tes);
           }else{
               flag = false;
           }

       }

     }

    }

    public static void main(String[] args) {
       threadTest3 test3=  new threadTest3();
        Thread t =new Thread(test3);
        Thread t1 =new Thread(test3);
        Thread t2 =new Thread(test3);
        Thread t3 =new Thread(test3);
        Thread t4 =new Thread(test3);
        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();



    }

}
