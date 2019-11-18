package com.sjms.单例模式;

/**
 * 多线程环境下 对外存在一个对象   懒汉式基础加并发控制
 * 构造器私有化
 * 提供私有静态属性  存对象地址
 *
 * 提供公共静态方法  获取属性
 *
 * DCL 双重检测
 */
public class DoubleCheckedLocking {
    private static volatile DoubleCheckedLocking instance;
    //.构造器私有
    private DoubleCheckedLocking(){

    }
    public static DoubleCheckedLocking getInstance(){
        if(null!=instance){
            return instance;
        }
        synchronized (DoubleCheckedLocking.class){
            if (instance == null) {
                instance = new DoubleCheckedLocking();
                //1开辟空间   2初始化  3对象地址返回给引用
            }
            return instance;
        }

    }

}
