package com.hbxy.io;

import java.io.UnsupportedEncodingException;

/**
 * 解码   字节-->字符串
 */
public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg="笑看后视镜的自己";
        //编码
        byte[] datas=msg.getBytes(); //默认使用工程的字符集

        //解码
        msg=new String(datas,0,datas.length,"utf-8");
        System.out.println(msg);
    }
}
