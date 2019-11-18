package com.hbxy.io3;

import java.io.InputStream;
import java.net.DatagramPacket;

/**
 * 模拟咖啡
 * 抽象组件   需要装饰的抽象对象一般是接口  火抽象父类
 * 具体组件   需要装饰的对象
 * 抽象装饰类  包含了对抽象组件的引用 以及装饰着共有的方法
 * 具体装饰类 被装饰的对象
 */
public class DecorateTest02 {
    public static void main(String[] args) {

    }
}
interface Drink{
    double cost();
    String info();
}
class Coffee implements Drink{
    private String name="原味咖啡";
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}
//抽象装饰类
abstract class Decorate implements  Drink{

    private  Drink drink;
    public Decorate(Drink drink){
        this.drink=drink;
    }
    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

//具体装饰类
class Milk extends Decorate{


    public Milk(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info()+"加入牛奶";
    }
}