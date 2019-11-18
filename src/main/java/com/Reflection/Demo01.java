package com.Reflection;

/**
 * 测试java.lang.Class对象的获取方式
 *各种类型
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        String path="com.Reflection.User";
        try {
            Class clz=Class.forName(path);
            //对象是标识或封装一些数据，类被加载后，
            // jvm会创建一个对应该类的Class对象类的整个结构信息会放到对应的Class对象中
            //一个类只有一个Class对象（class文件里放的应该就是class对象？？）

            Class clz2=Class.forName(path);
            System.out.println(clz.hashCode()+" "+clz2.hashCode());


            Class strClz=String.class;
            Class strClz2=path.getClass();
            System.out.println(strClz==strClz2);
            Class strClz3=strClz2.getClass();
            System.out.println(strClz3.hashCode());
            Class strClz4=strClz.getClass();
            System.out.println(strClz4.hashCode());

            Class intClz=int.class;

            int[] arr01=new int[10];
            int[] arr02=new int[30];
            int[][] arr03=new int[30][12];
            double[] arr04=new double[10];
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());
            System.out.println(arr03.getClass().hashCode());
            System.out.println(arr04.getClass().hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
