package com.hbxy.io;

import java.io.File;

/**
 * 其他信息
 *
 * length()  文件的字节数 放回long
 */
public class FileDemo05 {
    public static void main(String[] args) {
        File src=new File("F:/webhaha/src/main/java/com" +
                "/hbxy/io/IMG_20161010_115415.png");
        System.out.println("长度"+src.length());
    }
}
