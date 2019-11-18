package com.hbxy.webstudy.state;

/**
 * 合并线程 （插队线程）
 */
public class Join  {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("爸爸和儿子买烟的故事");
        new Thread(new Father()).start();

    }
}
class Father extends Thread{
    public void run(){
        System.out.println("想抽烟发现没了");
        System.out.println("让儿子买烟");
        Thread t=new Thread(new Son());
        t.start();
        try {
            t.join();//father被阻塞
            System.out.println("老爸拿到烟");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("孩子走丢了");
        }

    }
}
class Son extends Thread{
    @Override
    public void run() {
        System.out.println("拿钱去买烟了");
        System.out.println("路边有个游戏厅,玩了十秒");
        for (int i=0;i<10;i++){
            System.out.println(i+"秒过去了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("赶紧买烟去...");
        System.out.println("拿包中华回家...");
    }
}
