package com.sjms.单例模式;

/**
 * 饿汉式单例模式
 */
public class SingletonDemo1 {
    //类初始化时 立即加载
    private static SingletonDemo1 instance=new SingletonDemo1();
    private SingletonDemo1(){
    }

    public static SingletonDemo1 getInstance(){
        return instance;
    }
}
