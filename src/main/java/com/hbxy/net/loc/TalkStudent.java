package com.hbxy.net.loc;

/**
 * 加入多线程 实现双向交流  模拟在线咨询
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"127.0.0.1",9999)).start();
        new Thread(new TalkReceive(6666)).start();
    }
}
