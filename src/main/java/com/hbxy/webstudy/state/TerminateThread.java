package com.hbxy.webstudy.state;


import java.time.temporal.Temporal;

/**
 * 终止线程
 *1.线程正常执行完毕
 * 2.外部干涉---加入标识位
 *
 * 不要用stop()  destroy()  不安全
 */
public class TerminateThread implements Runnable{
    //加入表示 标记线程体是否可以运行
    private boolean flag=true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }


    //2. 关联标识，
    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println(name+"-->"+i++);
        }
    }
    //3. 对外提供方法改变标识
    public void terminate(){
        flag=false;
    }

    public static void main(String[] args) {
        TerminateThread tt=new TerminateThread("C黄");
        new Thread(tt).start();

        for(int i=0;i<=99;i++){
            if (i==88){
                tt.terminate();
                System.out.println("tt over");
            }
            System.out.println("main-->"+i);
        }
    }
}
