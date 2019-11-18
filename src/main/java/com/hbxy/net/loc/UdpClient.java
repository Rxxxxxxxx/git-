package com.hbxy.net.loc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 *  1、使用DataGramSocket  指定端口  创建发送端
 *  2、准备数据  一定要转成字节数组
 *  3、封装成DatagramPacket 包   需要指定目的地
 *  4、发送包裹send(DatagramPacket p)
 *  5、释放资源
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中......");
        DatagramSocket client = new DatagramSocket(8888);
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();

            DatagramPacket packet = new DatagramPacket(datas,
                    0, datas.length, new InetSocketAddress("127.0.0.1", 9999));

            client.send(packet);
            if (data.equals("bye")){
                break;
            }
        }
        client.close();
    }
}
