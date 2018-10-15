package com.friend.spider.test.zhangqi;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用线程池读取文件
 */

public class threadTest4 {


    public void copyInfo(List<String> path, List<String> copyPath) {
        List<pathInfo> pathInfoList = new ArrayList<>();
         int countNum =0;
        for (int i = 0; i < path.size(); i++) {
            countNum++;
            pathInfo pathInfo = new pathInfo();
            pathInfo.setId(countNum);
            pathInfo.setPath(path.get(i));
            pathInfo.setCopyPath(copyPath.get(i));
            pathInfoList.add(pathInfo);

            System.out.println("countNum"+countNum);
        }


        List<readInfoTask> tasks = new ArrayList<>();


        for (pathInfo pathInfo : pathInfoList) {

            readInfoTask task = new readInfoTask(new readInfoHelp(pathInfo.getPath(), pathInfo.getCopyPath()),pathInfo.getId());
            tasks.add(task);

        }

        for (readInfoTask task : tasks) {
            threadPool.executor.execute(task);
            System.out.println("taskNUm:"+countNum);
        }



    }



    public static void main(String[] args) {
        List<String> path = new ArrayList<String>();
        path.add("D:/复制文件源/链表.txt");
        path.add("D:/复制文件源/学习记录.txt");
        List<String> copyPath = new ArrayList<String>();
        copyPath.add("D:/复制文件源Copy/链表.txt");
        copyPath.add("D:/复制文件源Copy/学习记录.txt");

        threadTest4 threadTest4 = new threadTest4();
        threadTest4.copyInfo(path, copyPath);

    }
}
