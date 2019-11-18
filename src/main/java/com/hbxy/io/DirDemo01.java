package com.hbxy.io;

import java.io.File;

/**
 * 创建目录
 * 1、mkdir()  上级目录不存在  创建失败
 * 2、mkdirs()  上级目录不存在 一同创建
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir=new File("F:/webhaha/src/main/java/com/hbxy/io/test");
        boolean flag=dir.mkdirs();
        System.out.println(flag);
    }
}
