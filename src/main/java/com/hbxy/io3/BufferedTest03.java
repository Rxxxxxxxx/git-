package com.hbxy.io3;

import java.io.*;

/**
 * 分段读取   文件字符输入流 加入缓冲流
 * 1创建源
 * 2选择流
 * 3操作
 * 4释放资源
 */
public class BufferedTest03 {
    public static void main(String[] args) {

        File src=new File("F:/webhaha/src/main/java/com/hbxy/io3/abc.txt");

        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new FileReader(src));
            String line = null;
            while((line=reader.readLine())!=null){
                //字符数组  不需要解码
                System.out.println(line);
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
