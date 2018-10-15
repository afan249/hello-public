package com.friend.spider.test.zhangqi;

import java.io.File;
import java.io.IOException;

/**
 * 文件的基本操作
 * 1.文件的创建
 * 2.文件的删除
 */

public class fileOper {
    public static  void main(String [] args){

        //创建一个word.txt文件，在默认当前项目路径下
        File file = new File("word.txt");
        if (file.exists()) {
            String fileName = file.getName();
            long length = file.length();
            boolean hidden = file.isHidden();
            String absolutePath = file.getAbsolutePath();
            System.out.println("文件名:" + fileName);
            System.out.println("文件长度:" + length);
            System.out.println("是否是隐藏:" + hidden);
            System.out.println("文件的路径:" + absolutePath);

        }else{

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("文件已创建");

        }
    }

}
