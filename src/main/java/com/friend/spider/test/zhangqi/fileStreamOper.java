package com.friend.spider.test.zhangqi;

import java.io.*;

/**
 * 文件流的基本操作
 * 1.写文件
 * 2.读文件
 */
public class fileStreamOper {
    public static void main(String[] args) {

        File file = new File("wordStream.txt");
        String info = null;
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // FileOutputStream 输入字节流 ,FileInputStream 输出字节流
        // 创建字节文件输入流对象
        try {
            FileOutputStream out = new FileOutputStream(file);

            byte output[] = "Start study FileOutputStrean,练习中".getBytes();

            out.write(output);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] input = new byte[1024];
            //  把流读进去
            int read = fileInputStream.read(input);
            //显示出来
            info = new String(input, 0, read);
            System.out.println("打印输入流输入的字符串:" + info);
            input.clone();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
