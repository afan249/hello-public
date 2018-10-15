package com.friend.spider.test.zhangqi;

import java.io.*;

/**
 * buffer Io
 */
public class bufferIoBase {
    public static void main(String[] args) {
        //定义字符串数组
        String[] conttent = {"学习java", "学习基础", "开始学习"};
        File file = new File("wordText");
        if (file.exists()) {
            try {
                FileWriter fw = new FileWriter(file);
                //创建 BufferedWrite 类对象
                BufferedWriter bfwr = new BufferedWriter(fw);
                for (int k = 0; k < conttent.length; k++) {
                    bfwr.write(conttent[k]);
                    bfwr.newLine();
                }
                bfwr.close();
                fw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
         //

            FileReader fr = null;
            try {
                fr = new FileReader(file);

            //创建BufferedReader 类对象
            BufferedReader bufr = new BufferedReader(fr);

            String s = null;
            int i=0;
            // 如果文件的文本行数不为 null ,则进入循环
            while ((s= bufr.readLine())!=null){
               i++;
               System.out.println("第"+i+"行"+s);
            }

            bufr.close();
            fr.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
