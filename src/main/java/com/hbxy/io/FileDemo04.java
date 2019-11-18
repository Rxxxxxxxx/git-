package com.hbxy.io;

import java.io.File;

/**
 * 文件状态
 * 1、不存在 exists
 * 2、存在
 *    文件  isFile
 *    目录 isDirectory
 */
public class FileDemo04 {
    public static void main(String[] args) {
        File src=new File("com/hbxy/io/IMG_20161010_115415.png");
        System.out.println("是否存在："+src.exists());
        System.out.println("是否是文件："+src.isFile());
        System.out.println("是否是文件夹："+src.isDirectory());


        src=new File("F:/webhaha/src/main/java/com/hbxy/io/IMG_20161010_115415.png");
        System.out.println("是否存在："+src.exists());
        System.out.println("是否是文件："+src.isFile());
        System.out.println("是否是文件夹："+src.isDirectory());
    }
}
