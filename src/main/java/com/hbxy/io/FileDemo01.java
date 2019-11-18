package com.hbxy.io;

import java.io.File;

/**
 * 构建File对象
 *  相对路径  和绝对路径
 *  有盘符  绝对路径
 *  无盘符  相对路径
 */
public class FileDemo01 {
    public static void main(String[] args) {
        String path="F:/webhaha/src/main/java/com/hbxy/io/IMG_20161010_115415.png";
/*
        //构建File对象
        File src=new File(path);
        System.out.println(src.length());

        //构建File对象
        src=new File("F:/webhaha/src/main/java/com/hbxy/io","IMG_20161010_115415.png");
        System.out.println(src.length());

        //3 构建File对象
        src=new File(new File("F:/webhaha/src/main/java/com/hbxy/io"),"IMG_20161010_115415.png");
        System.out.println(src.length());*/

        File src=new File(path);
        System.out.println(src.getAbsolutePath());

        System.out.println(System.getProperty("user.dir"));

        src = new File("./IMG_20161010_115415.png");
        System.out.println(src.getAbsolutePath());

    }
}
