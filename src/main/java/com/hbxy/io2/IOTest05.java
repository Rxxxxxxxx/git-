package com.hbxy.io2;

import java.io.*;

/**
 * 分段读取   文件字符输入流
 * 1创建源
 * 2选择流
 * 3操作
 * 4释放资源
 */
public class IOTest05 {
    public static void main(String[] args) {

        File src=new File("F:/webhaha/src/main/java/com/hbxy/io2/abc.txt");

        Reader reader=null;
        try {
            reader=new FileReader(src);
            char[] car=new char[1024];  //缓冲容器
            int len=-1;  //接收长度
            while((len=reader.read(car))!=-1){
                //字符数组  不需要解码了
                String str=new String(car,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
