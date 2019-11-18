package com.hbxy.webstudy.state;

/**
 * 线程优先级 1-10
 * 1. NORM_PRIORITY  5
 * 2.MIN_PRIORITY  1
 * 3.MAX_PRIORITY  10
 */
public class Priority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());

        MyPri m=new MyPri();
        Thread t1=new Thread(m);
        t1.start();
    }
}
class MyPri implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getPriority());
    }
}