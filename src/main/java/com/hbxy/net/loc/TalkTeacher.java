package com.hbxy.net.loc;

/**
 * 加入多线程 实现双向交流  模拟在线咨询
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(4444,"127.0.0.1",6666)).start();
        new Thread(new TalkReceive(9999)).start();
    }
}
