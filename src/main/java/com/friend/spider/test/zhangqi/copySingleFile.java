package com.friend.spider.test.zhangqi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class copySingleFile {

    /**
     * 指定文件目录下
     * 复制一个文件
     * @param src
     * @param dst
     */
    public void copyFile(String src ,String dst) {

//        File srcfile = new File(src);
//        //1.判断文件源文件是否存在
//        if (!srcfile.exists()) {
//            System.out.println("源文件不存在");
//            return;
//        }
//        File dstfile = new File(dst);
//        //2.目标文件是否存在，如果不存在获取源文件的上级目录并创建文件目录
//        if (!dstfile.exists()) {
//            File parentFile = srcfile.getParentFile();
//            if (!parentFile.exists()) {
//                dstfile.mkdirs();
//            }
//        }
//
//        try {
//            //将源文件中的数据读到文件输出流
//            FileInputStream fin = new FileInputStream(srcfile);
//            FileOutputStream fout = new FileOutputStream(dstfile);
//            byte[] bt = new byte[512];
//            //循环将文件中的数据写入到目标路径中文件中
//            while (fin.read(bt) != -1) {
//                fout.write(bt, 0, bt.length);
//            }
            System.out.println("复制完成");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public static void main(String[] args) {
            String scrPath ="D:/复制文件源/学习记录.txt";
            String dsrPath ="D:/复制文件源/学习记录copy.txt";

            copySingleFile copyFile = new copySingleFile();

            copyFile.copyFile(scrPath,dsrPath);
    }
}
