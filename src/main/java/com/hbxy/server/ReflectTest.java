package com.hbxy.server;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射  把java类中的各种结构 (方法、属性、构造器、类名)映射成一个个的java对象
 * 1、获取Class对象
 * 三种方式   Class.forName("包名.类名");
 * 2、可以动态创建对象
 * clz.getConstructor().newInstance();
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //三种方式
        //1、对象.getClass()
        Class clz=new Iphone().getClass();
         //2、类.class()
        clz=Iphone.class;
        //3、Class.forName("包名.类名");
        clz=Class.forName("com.hbxy.server.Iphone");

        /*Iphone iphone=(Iphone)clz.newInstance();
        System.out.println(iphone);*/
        Iphone iphone2=(Iphone)clz.getConstructor().newInstance();
        System.out.println(iphone2);
        Field f=clz.getDeclaredField("i");
        f.setAccessible(true);
        f .set(iphone2,1);
        System.out.println(f.get(iphone2));
    }
}
class Iphone{
    private  int i=0;
    public Iphone(){
    }
}