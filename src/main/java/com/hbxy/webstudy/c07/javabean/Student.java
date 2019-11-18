package com.hbxy.webstudy.c07.javabean;

public class Student {
    private String sid;
    private String name;
    private int age;
    private boolean married;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isMarried() {
        return married;
    }
    public void setMarried(boolean married) {
        this.married = married;
    }
    public String getSid() {
        return sid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void getInfo() {
        System.out.print("I AM A STUDENT");
    }

}
