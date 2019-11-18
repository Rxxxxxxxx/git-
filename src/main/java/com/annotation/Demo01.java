package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射 读取注解的信息，模拟处理注解信息的流程
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            Class clz=Class.forName("com.annotation.Student");

            //获得类的所有有效注解
            Annotation[] annotations=clz.getAnnotations();
            for (Annotation a: annotations){
                System.out.println(a);
            }
            //获得类指定的注解
            StuTable st=(StuTable) clz.getAnnotation(StuTable.class);
            System.out.println(st.value());
            //获得属性的注解
            Field f=clz.getDeclaredField("name");
            StuField stuField=f.getAnnotation(StuField.class);
            System.out.println(stuField.columnName()+"--"+stuField.type());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
