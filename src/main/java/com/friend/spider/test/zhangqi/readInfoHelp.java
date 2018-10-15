package com.friend.spider.test.zhangqi;

public class readInfoHelp {

    private String path;
    private String copyPath;

    public readInfoHelp(String path, String copyPath) {
        this.copyPath = copyPath;
        this.path = path;

    }

    public void copyData() {
        copySingleFile copySingleFile = new copySingleFile();
        copySingleFile.copyFile(path, copyPath);




    }
}
