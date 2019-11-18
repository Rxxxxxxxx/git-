package com.hbxy.io3;

import java.io.*;

/**
 * 转换流
 * 以字符流的形式操作字节流 纯文本
 * 指定字符集
 */
public class ConvertTest {
    public static void main(String[] args) {
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));) {
            String msg="";
            while (!msg.equals("exit")){
                msg=reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
