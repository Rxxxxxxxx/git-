package com.hbxy.io2;

import java.io.*;

/**
 * 分段读取   文件字节输入流
 * 1创建源
 * 2选择流
 * 3操作
 * 4释放资源
 */
public class IOTest03 {
    public static void main(String[] args) {

        File src=new File("F:/webhaha/src/main/java/com/hbxy/io2/abc.txt");

        InputStream is=null;
        try {
            is=new FileInputStream(src);
            byte[] car=new byte[1024];  //缓冲容器
            int len=-1;  //接收长度
            while((len=is.read(car))!=-1){
                //字符数组到字符串
                String str=new String(car,0,len);
                System.out.println(str);
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
