package com.sjms.单例模式;

/**
 * 没有延时加载
 * 枚举实现单例
 */
public enum SingletonDemo5 {
    //这个枚举元素 本身就是单例对象
    INSTANCE;

    //添加自己想要的操作
    public void singletonOperation(){

    }
}
