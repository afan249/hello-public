package com.friend.spider.test.zhangqi;

import java.io.*;

public class gitBaseInfo {
    public static void main(String[] args) {

        File file = new File("word.txt");
        File fileToChar = new File("wordtoChar");
        if (!fileToChar.exists()) {
            try {
                fileToChar.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String intoTochar = null;
        String info = null;
        //FileInputStream 输出字节流 ，FileOutputStream 输入字节流
        //2.创建字节文件流对象,将入职
        try {
            FileOutputStream out = new FileOutputStream(file);

            byte output[] = "Start study FileOutputStrean,练习中".getBytes();

            try {
                out.write(output);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] input = new byte[1024];
            //  把流读进去
            int read = fileInputStream.read(input);
            //显示出来
            info = new String(input, 0, read);
            input.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //创建字符流 fileReader fileWrite
        // 写字符进去
        try {
            FileWriter fileWriter = new FileWriter(fileToChar);

            fileWriter.write("字符输入练习");

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader reader = null;
        try {
            reader = new FileReader(fileToChar);

            char[] charInfo = new char[1024];

            int read = reader.read(charInfo);

            intoTochar  =  new String(charInfo,0,read);


        } catch (Exception e) {
            e.printStackTrace();
        }


        if (file.exists()) {
            String fileName = file.getName();
            long length = file.length();
            boolean hidden = file.isHidden();
            String absolutePath = file.getAbsolutePath();
            System.out.println("文件名：" + fileName);
            System.out.println("文件长度：" + length);
            System.out.println("是否是隐藏" + hidden);
            System.out.println("绝对路径：" + absolutePath);
            System.out.println("获取读入输出的语句：" + info);
            System.out.println("获取字符输入输出的语句："+intoTochar);
        } else {
            System.out.println("不存在");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("创建一个文件");
        }
    }
}
