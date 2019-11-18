package com.hbxy.webstudy.thread;

public class Web12306 implements Runnable{

    public int tick=100;
    @Override
    public void run() {
        while(true){
            if (tick<0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->"+tick--);
        }
    }

    public static void main(String[] args) {
        Web12306 web=new Web12306();
        new Thread(web,"11").start();
        new Thread(web,"22").start();
        new Thread(web,"33").start();
    }
}
