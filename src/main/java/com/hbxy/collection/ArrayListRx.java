package com.hbxy.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListRx<E> {
    public Object[] elementData;
    private int size;

    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    public void checkRange(int index){
        if (index<0||index>size-1){
            throw new RuntimeException("索引不合法："+index);
        }
    }

    public void set(E element,int index){
        checkRange(index);
        elementData[index]=element;
    }

    private static final int DEFALT_CAPACITY=10;

    public ArrayListRx(){
        elementData=new Object[DEFALT_CAPACITY];
    }

    public ArrayListRx(int capacity){
        elementData=new Object[capacity];
    }

    public void add(E element){
        if (size==elementData.length){
            //扩容操作
            Object[] newArray = new Object[elementData.length+elementData.length/2];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData=newArray;
        }
        elementData[size++]=element;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();

        sb.append("[");
        for (int i=0;i<size;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public void remove(E element){
        for (int i=0;i<size;i++){
            if(element.equals(get(i))){
                //衣橱元素
                remove(i);
            }
        }
    }

    public void remove(int index){
        System.arraycopy(elementData,index+1,elementData,index,
                elementData.length-index-1);
        elementData[--size]=null;
    }

    public static void main(String[] args) {
        ArrayListRx<String> s1=new ArrayListRx<>(20);
        //ArrayList<String> s1=new ArrayList<>(20);
        for (int i=0;i<40;i++){
            s1.add("1"+i);
        }
        ArrayList al = new ArrayList();
        al.add(true);
        al.add(123);
        al.add("abc");

        //s1.set("hh",3);
        System.out.println(al);
    }
}
