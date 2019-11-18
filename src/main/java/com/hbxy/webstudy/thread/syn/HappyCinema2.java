package com.hbxy.webstudy.thread.syn;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema2 {
    public static void main(String[] args) {
        //可用位置
        List<Integer> available=new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(6);
        available.add(7);
        //顾客需要
        List<Integer> seats1=new ArrayList<>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2=new ArrayList<>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);


        Cinema2 c=new Cinema2(available,"flash");
        new Thread(new Customer2(c,seats1),"我").start();
        new Thread(new Customer2(c,seats2),"你").start();
    }
}

//顾客
class Customer2 implements Runnable{
    Cinema2 cinema;
    List<Integer> seats;

    public Customer2(Cinema2 cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "->位置是" + seats);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "->位置不够");
            }
        }
    }
}
//影院
class Cinema2{
    List<Integer> available;  //可用位置
    String name;  //名称

    public Cinema2(List<Integer> available, String name) {
        this.available=available;
        this.name = name;
    }
    //购票
    public boolean bookTickets(List<Integer> seats){
        System.out.println("可用位置为："+available);
        List<Integer> copy=new ArrayList<>();
        copy.addAll(available);

        //相减
        copy.removeAll(seats);
        //判断大小
        if (available.size()-copy.size()!=seats.size()){
            return false;
        }
        //成功
        available=copy;
        return true;

    }
}