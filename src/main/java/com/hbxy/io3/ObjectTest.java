package com.hbxy.io3;

import java.io.*;

public class ObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.writeObject("hahaha");
        oos.flush();
        byte[] datas=baos.toByteArray();
        System.out.println(datas.length);
        //读取
        ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        Object msg=ois.readObject();
        System.out.println(msg);
    }
}
