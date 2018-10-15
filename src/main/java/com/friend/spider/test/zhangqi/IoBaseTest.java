package com.friend.spider.test.zhangqi;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class IoBaseTest {
    public static void main(String[] args){

        String basePath ="D:/myGit/coypTest";
        String path ="D:/coypTest2/git/test.txt";

        //获取所有目录下的文件

        File file = new File(path);
       if (file.exists()){
           System.out.println("目录存在");
       }else{
           System.out.println("目录不存在");
           String pathP = file.getParent();
           System.out.println("pathP"+pathP);
           File file2 = new File(pathP);

           if(!file.isDirectory()){
              file2.mkdirs();
           }
           if(file.exists()){
               System.out.println("文件存在");

           }else{
               try {
                   file.createNewFile();
               } catch (IOException e) {
                   e.printStackTrace();
               }

           }




       }

    }

    /*public Map<String, List<String>> getDirectory(File file){
        File [] files = file.listFiles();
        Map<String, List<String>> map = null;
        if(files.length ==0 || files == null ){
            return null;
        }else {
          for (File f : files){
             if(f.isDirectory()){
                System.out.println("Dir"+f);
                getDirectory(f);
             }else{
                System.out.println("path");

             }

          }
        }

    }*/
}
