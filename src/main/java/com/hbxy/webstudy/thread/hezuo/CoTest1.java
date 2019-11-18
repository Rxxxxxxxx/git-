package com.hbxy.webstudy.thread.hezuo;

/**
 * 协作模型  生产者消费者 实现方式1  管程法
 *
 */
public class CoTest1 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    public void run(){
        //消费
        for(int i=0;i<100;i++){
            System.out.println("消费-->"+container.pop().id+"个馒头");
        }
    }
}

//生产者
class Productor extends  Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    public void run(){
        //生产
        for (int i=0;i<100;i++){
            System.out.println("生产-->"+i+"个馒头");
            container.push(new Mantou(i));
        }
    }
}

//缓冲区
class SynContainer{
    Mantou[] buns=new Mantou[10];
    int count=0;
    //生产
    public synchronized void push(Mantou bun){
        //容器存在空间 可以生产
        if(count == buns.length){
            try {
                this.wait(); //线程阻塞  消费者通知生产 解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间  可以生产
        buns[count] = bun;
        count++;
        //存在数据了 可以通知消费
        this.notifyAll();
    }
    //消费
    public synchronized Mantou pop(){
        //容器有数据 可以消费  没有 只能等待
        if(count == 0){
            try {
                this.wait();  //线程阻塞   生产者通知消费 解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在  可以消费
        count--;
        Mantou bun=buns[count];
        this.notifyAll();   //存在空间了 可以唤醒生产
        return bun;
    }
}

class Mantou{
    int id;

    public Mantou(int id) {
        this.id=id;
    }
}