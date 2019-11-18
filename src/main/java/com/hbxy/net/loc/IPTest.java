package com.hbxy.net.loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        //创建InetAddress对象
        InetAddress addr=InetAddress.getLocalHost();
        System.out.println(addr.getHostName());
        System.out.println(addr.getHostAddress());
    }

}
