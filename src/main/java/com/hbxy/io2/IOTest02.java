package com.hbxy.io2;

import java.io.*;

/**
 * 第一个程序 理解操作步骤
 * 1创建源
 * 2选择流
 * 3操作
 * 4释放资源
 */
public class IOTest02 {
    public static void main(String[] args) {
        File src=new File("F:/webhaha/src/main/java/com/hbxy/io2/abc.txt");
        InputStream is=null;
        try {
            is=new FileInputStream(src);
            int temp;
            while(( temp=is.read())!=-1){
                System.out.println((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
