package com.friend.spider.test.zhangqi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 复制一个
 */

public class copyAllFile {

    /**
     * 复制一个文件
     * @param src
     * @param dst
     */
    public void copyFile(String src ,String dst){
        File srcfile = new File(src);
        if (!srcfile.exists()){
            System.out.println("源文件不存在");
            return;
        }
        File dstfile = new File(dst);
        if(!dstfile.exists()){
            File parentFile = srcfile.getParentFile();
            if(!parentFile.exists()){
                dstfile.mkdirs();
            }
        }

        try {
            FileInputStream fin = new FileInputStream(srcfile) ;
            FileOutputStream fout = new FileOutputStream(dstfile);
            byte[] bt = new byte[512];

            while (fin.read(bt)!=-1){
                fout.write(bt,0,bt.length);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 复制文件夹
     * @param src
     * @param dst
     */
    public void copyFiles(String src,String dst){

        File srcfile = new File(src);
        //1.判断源文件是否存在
        if(!srcfile.exists()){
            System.out.println("源文件不存在");
            return;
        }
        //2.判断源文件是不是一个目录，如果不是一个目录就直接复制的单个文件
        if(!srcfile.isDirectory()){
            copyFile(src,dst);
            return;
        }
        //3.判读目标文件是否存在，如果不存在进行文件目录的创建
        File dsrfile = new File(dst);

        if(!dsrfile.exists()){
            dsrfile.mkdirs();
        }

        //4.复制文件夹信息
        copyListFile(srcfile,dsrfile);


    }

    public void copyListFile(File src,File dst){

        //5.获取所有文件File对象集合
        File [] listFile = src.listFiles();

        //6.判读文件集合中是否有文件存在，如果没有就返回
        if(listFile==null || listFile.length==0){
            return;
        }
        //7.循环遍历从目录外层开始
        for(File file : listFile){

            String oldPath =  file.getAbsolutePath();
            System.out.println("获取路径"+oldPath);

            int index = oldPath.lastIndexOf(File.separator);
            //8.获取文件名称
            String fileName = oldPath.substring(index);
            //9.创建目标文件
            File newFile = new File(dst.getAbsolutePath()+File.separator+fileName);
            //10.如果是一个目录,就根据源文件先创建目标文件目录并递归调用，一层层循环直到找到文件进行复制
            if(file.isDirectory()){
                newFile.mkdirs();
                copyListFile(file,newFile);

            }else{
            //11.如果是一个文件，就直接调用复制单个文件的方法进行复制
                copyFile(oldPath,dst.getAbsolutePath()+File.separator+fileName);
            }


        }

    }



    public static void main(String[] args ){
        String scrPath ="D:/复制文件源";
        String dsrPath ="D:/复制文件源Copy";

        copyAllFile copyFile = new copyAllFile();

        copyFile.copyFiles(scrPath,dsrPath);


    }



}
