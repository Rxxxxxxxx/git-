package com.hbxy.io2;

import java.io.*;

/**
 * 字节数组输入流
 * 1创建源  字节数组
 * 2选择流
 * 3操作
 * 4释放资源   可以不用处理
 */
public class IOTest07 {
    public static void main(String[] args) {
        // 创建源
        byte[] src= "talk is cheap show me the code".getBytes();
        InputStream is=null;
        try {
            is=new ByteArrayInputStream(src);
            byte[] car=new byte[5];  //缓冲容器
            int len=-1;  //接收长度
            while((len=is.read(car))!=-1){
                //字符数组到字符串
                String str=new String(car,0,len);
                System.out.println(str);
            }
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
