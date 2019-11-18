package com.hbxy.io2;

import java.io.*;

/**
 * 文件字节输出流
 * 创建源
 * 选择流
 * 操作    写出内容
 * 释放资源
 */
public class IOTest04 {
    public static void main(String[] args) {
        File dest=new File("dest.txt");
        OutputStream os=null;
        try{
            os=new FileOutputStream(dest);
            //写出
            String msg="IO is so easy";
            byte[] datas=msg.getBytes();
            os.write(datas,0,datas.length);
            os.flush();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
