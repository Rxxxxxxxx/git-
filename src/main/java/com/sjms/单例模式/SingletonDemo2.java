package com.sjms.单例模式;

/**
 * 懒汉式单例模式
 */
public class SingletonDemo2 {
    //类初始化时  不初始化这个对象  延时加载
    private static SingletonDemo2 instance;
    private SingletonDemo2(){
            if(instance!=null){
                throw new RuntimeException();
            }
            instance=this;
    }

    public static synchronized SingletonDemo2 getInstance(){
        if(instance==null){
            instance=new SingletonDemo2();
        }
        return instance; 
    }
}
