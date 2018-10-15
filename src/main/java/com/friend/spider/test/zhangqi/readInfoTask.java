package com.friend.spider.test.zhangqi;

public  class readInfoTask implements  Runnable {
    private  readInfoHelp readInfoHelp;
    private  int num ;

    public  readInfoTask(readInfoHelp readInfoHelp,int num){
        super();
        this.readInfoHelp = readInfoHelp;
        this.num =num;

    }

    @Override
    public void run() {

        readInfoHelp.copyData();
        num--;
        finish(num);
    }

    public  void finish(int num){
        if(num ==0){
            threadPool.executor.shutdown();
        }
    }
}
