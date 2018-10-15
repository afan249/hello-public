package com.friend.spider.test.zhangqi;

import java.io.File;
import java.io.IOException;

public class fileTest {

    public boolean createFile(String path) {

        boolean result = false;
        File file = new File(path);
        //1.判读文件是否存在
        if (file.exists()) {
            result = true;
        } else {
            //2.判读文件是一个目录吗，如果是目录,就创建所有目录使用mkdirs(包括子目录)
            if (file.isDirectory()) {
                file.mkdirs();
            } else {
                //3.如果不是目录,获取父目录
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    //4.父目录不存在，就先创建目录，再创建文件
                    file.createNewFile();
                    result = true;
                } catch (IOException e) {
                    e.printStackTrace();
                    result = false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        fileTest fileTest = new fileTest();

        String path = "D:/coypTest2/git/test1.txt";

        System.out.println("文件是否已经被创建ok?" + fileTest.createFile(path));
    }
}
