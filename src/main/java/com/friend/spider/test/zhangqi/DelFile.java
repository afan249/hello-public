package com.friend.spider.test.zhangqi;

import java.io.File;

public class DelFile {

    public void DelFile(String path){
        File file = new File(path);

        if(!file.exists()){
            System.out.println("源文件不存在");
        }
        file.delete();
    }

    public void DelFiles(String path){
        File filePath = new File(path);
        //1.获取指定目录下的所有文件集合
        File[] files = filePath.listFiles();
        if(files ==null || files.length==0){
            return;
        }
        //2.开始遍历删除文件和文件目录
        for(File file :files){
            String newPath = file.getAbsolutePath();
            //3.判断是否为文件目录，如果是目录就进行递归调用,直到找到文件
            if(file.isDirectory()){
                DelFiles(newPath);
                file.delete();
            }else{
            //4.判断是文件就直接调用单个文件删除
                DelFile(newPath);
            }

        }
        //5.当所有文件都删除后,删除最外层文件目录
        filePath.delete();

    }


    public static void main(String[] args ){
        String delPath ="D:/复制文件源Copy";
        DelFile del = new DelFile();
        del.DelFiles(delPath);
    }
}
