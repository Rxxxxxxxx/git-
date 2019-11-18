package com.hbxy.io2;

import java.io.*;

/**
 * 字节数组输出流  ByteArrayOutputStream
 * 创建源
 * 选择流
 * 操作    写出内容
 * 释放资源
 */
public class IOTest08 {
    public static void main(String[] args) {

        //创建源  实际用不到  统一风格用
        byte[] dest=null;
        //选择流 新增方法
        ByteArrayOutputStream baos=null;
        try{
            baos=new ByteArrayOutputStream();
            //写出
            String msg="show me the code";
            byte[] datas=msg.getBytes();
            baos.write(datas,0,datas.length);
            baos.flush();
            //获取数据
            dest=baos.toByteArray();
            System.out.println(new String(dest,0,baos.size()));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
