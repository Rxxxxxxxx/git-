package com.hbxy.webstudy.state;

/**
 * sleep() 模拟网络延时  放大了问题
 */
public class BlockedSleep01 {

    public static void main(String[] args) {
        Web12306 web=new Web12306();
        new Thread(web,"11").start();
        new Thread(web,"22").start();
        new Thread(web,"33").start();
    }
}
class Web12306 implements Runnable{
//票数
    public int tick=100;
    @Override
    public void run() {
        while(true){
            if (tick<0){
                break;
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