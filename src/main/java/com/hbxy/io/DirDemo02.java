package com.hbxy.io;

import java.io.File;

/**
 * 列出下一级
 * 1、list() 列出下一级名称
 * 2、listFiles() 列出下级File对象
 *
 * 列出所有盘符   listRoots()
 */
public class DirDemo02 {
    public static void main(String[] args) {
        File dir=new File("F:/webhaha/src/main/java/com/hbxy/io");
        String[] subNames=dir.list();
        for (String s:subNames){
            System.out.println(s);
        }

        //下级对象  listFiles()
        File[] subFiles=dir.listFiles();

    }
}
