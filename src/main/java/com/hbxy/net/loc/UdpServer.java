package com.hbxy.net.loc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * 1、使用DataGramSocket  指定端口  创建接收端
 * 2、准备容器  封装成DatagramPacket 包
 * 3、阻塞式接收包 receive(DatagramPacket p)
 * 4、分析数据
 *     byte[] getData()
 *              getLength()
 * 5、释放资源
 */
public class UdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中...");

        DatagramSocket server=new DatagramSocket(9999);
        while (true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);

            server.receive(packet);

            byte[] datas = packet.getData();

            String data=new String(datas, 0, packet.getLength());
            System.out.println(data);
            if (data.equals("bye")){
                break;
            }
        }
        server.close();
    }
}
