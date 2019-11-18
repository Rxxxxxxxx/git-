package com.hbxy.io;

import java.io.File;
import java.io.IOException;

/**
 * 其他信息
 *
 * createNewFile()   不能创建文件夹  不存在才能创建
 * delete()    删除存在的文件
 */
public class FileDemo06 {
    public static void main(String[] args) throws IOException {
        File src=new File("F:/webhaha/src/main/java/com" +
                "/hbxy/io/ls.txt");
        boolean flag=src.createNewFile();
        System.out.println(flag);

        flag = src.delete();
        System.out.println(flag);
    }
}
