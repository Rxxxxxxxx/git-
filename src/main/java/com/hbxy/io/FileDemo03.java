package com.hbxy.io;

import java.io.File;

/**
 * 名称或路径
 * getName  getPath
 * getAbsolutePath    getParent
 */
public class FileDemo03 {
    public static void main(String[] args) {
        File src=new File("com/hbxy/io/IMG_20161010_115415.png");
        System.out.println(":名称"+src.getName());
        System.out.println("路径："+src.getPath());
        System.out.println("绝对路径："+src.getAbsolutePath());
        System.out.println("父路径："+src.getParent());
    }
}
