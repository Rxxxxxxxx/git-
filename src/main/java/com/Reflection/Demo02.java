package com.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API获取类的信息（类名 属性 方法 构造器等）
 */
public class Demo02 {
    public static void main(String[] args) {
        String path="com.Reflection.User";
        try {
            Class clz=Class.forName(path);

            //获取类的名字
            System.out.println(clz.getName());
            System.out.println(clz.getSimpleName());

            //获取类的属性
            // getFields  只能获得public的field  同时能获得继承到的field
            //Field[] fields = clz.getFields();
            Field[] fields=clz.getDeclaredFields(); //无法获得继承到的field
            System.out.println(fields.length);
            Field f=clz.getDeclaredField("name");
            for (Field t:fields){
                System.out.println("属性:"+t);
            }
            //获取类的方法
            Method[] methods=clz.getDeclaredMethods();
            Method m=clz.getDeclaredMethod("getName");
            //如果方法有参数，必须传参数类型对应的class对象 （ 因为方法可能重载 不传参无法区分）
            Method m2=clz.getDeclaredMethod("setName",String.class);
            for(Method t:methods){
                System.out.println("方法名"+t);
            }

            //获得构造器信息
            //获得所有
            Constructor[] constructors=clz.getDeclaredConstructors();
            //获得指定
            Constructor c=clz.getDeclaredConstructor(null);
            System.out.println("指定构造器:"+c);
            Constructor c2=clz.getDeclaredConstructor(int.class,int.class,String.class);
            for(Constructor t:constructors){
                System.out.println("构造方法名"+t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
