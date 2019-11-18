package com.hbxy.io2;

import java.io.*;

/**
 * 第一个程序 理解操作步骤
 * 1创建源
 * 2选择流
 * 3操作
 * 4释放资源
 */
public class IOTest01 {
    public static void main(String[] args) {
        File src=new File("F:/webhaha/src/main/java/com/hbxy/io2/abc.txt");
        try {
            InputStream is=new FileInputStream(src);
            int data1=is.read();
            int data2=is.read();
            System.out.println((char)data1);
            System.out.println((char)data2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
