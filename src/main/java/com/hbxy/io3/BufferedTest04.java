package com.hbxy.io3;

import java.io.*;

/**
 * 文件字符输出流 加入缓冲流
 * 创建源
 * 选择流
 * 操作    写出内容
 * 释放资源
 */
public class BufferedTest04 {
    public static void main(String[] args) {
        File dest=new File("dest.txt");
        BufferedWriter writer =null;
        try{
            writer=new BufferedWriter(new FileWriter(dest));
            //写出  写法1
//            String msg="IO is so easy 笑看";
//            char[] datas=msg.toCharArray();
//            writer.write(datas,0,datas.length);

//            String msg="IO is so easy 笑看";
//            writer.write(msg);
//            writer.flush();

            writer.append("haha 笑看后视镜的自己");
            writer.newLine();
            writer.append("鬼啊");
            writer.flush();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
