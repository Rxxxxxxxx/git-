package com.hbxy.webstudy.thread.syn;


/**
 * 在并发时 保证数据的正确性，效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块
 */
public class SynTest1{
    public static void main(String[] args) {
        SafeWeb12306 web=new SafeWeb12306();
        new Thread(web,"11").start();
        new Thread(web,"22").start();
        new Thread(web,"33").start();
    }
}
class SafeWeb12306 implements Runnable{
    //票数
    public int tick=20;
    public boolean flag=true;
    @Override
    public void run() {
        while(flag){
            text1();
        }
    }
    public  void  text1(){
        synchronized(this ){
            if (tick<=0){
                flag=false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+tick--);
        }

    }

}