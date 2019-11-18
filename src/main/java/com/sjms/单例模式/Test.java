package com.sjms.单例模式;

import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) throws Exception{
        Class clz=Class.forName("com.sjms.单例模式.SingletonDemo2");
        Constructor c=clz.getDeclaredConstructor(null);

        c.setAccessible(true);

        SingletonDemo2 s1=(SingletonDemo2) c.newInstance();
        SingletonDemo2 s2=(SingletonDemo2) c.newInstance();

        System.out.println(s1+"    "+s2);

    }
}
