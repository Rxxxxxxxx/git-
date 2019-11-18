package com.hbxy.io;

import java.io.File;

/**
 * 递归  方法自己调自己
 * 递归头   何时结束递归
 * 递归体  重复调用
 *
 * 打印子孙级目录
 */
public class DirDemo03 {
    public static void main(String[] args) {
        File src=new File("C:\\Users\\Administrator\\Desktop/123456");
        printName(src);
    }
    public static void printName(File src){
        System.out.println(src.getName());
        if(src==null||!src.exists()){
            return;
        }else if (src.isDirectory()){
            for(File s:src.listFiles()){
                printName(s);
                s.delete();
            }
        }
    }
}
