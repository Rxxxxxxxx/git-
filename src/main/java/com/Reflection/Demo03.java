package com.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API 动态的操作  构造器 方法 属性
 *
 */
public class Demo03 {
    public static void main(String[] args) {
        //动态操作构造器
        String path="com.Reflection.User";
        try {
            Class<User> clz= (Class<User>) Class.forName(path);
            //通过反射 调用构造方法 构造对象
            User u=clz.newInstance();  //其实是调用了User的无参构造方法
            //所以 javabean必须有一个 无参构造器
            System.out.println(u);

            Constructor<User> c=clz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2=c.newInstance(1,18,"Rx");
            System.out.println(u2.getName());

            //通过反射api调用普通方法
            User u3=clz.newInstance();
            //u3.setName("Rxxx");  下面两行代码 相当于实现了这条
            Method method=clz.getDeclaredMethod("setName",String.class);
            method.invoke(u3,"Rxxx");
            System.out.println(u3.getName());

            //通过反射api操作属性
            User u4=clz.newInstance();
            Field f=clz.getDeclaredField("name");
            f.setAccessible(true);   //这个属性不用安全检查 直接访问  访问private属性
            f.set(u4,"Rxxx4");   //通过反射设置属性值
            System.out.println(f.get(u4));  //通过反射读属性值
            System.out.println(u4.getName());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
