package com.hbxy.collection;


import java.util.LinkedList;

class Node{
    Node previous;
    Node next;
    Object element;

    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}

public class LinkedListRx {
    private Node first;
    private Node last;
    private int size;

    public void add(Object obj){
        Node node=new Node(obj);

        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        Node temp=first;
        while (temp!=null){
            sb.append(temp.element+".");
            temp=temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkedListRx list = new LinkedListRx();
        list.add("a");
        list.add("b");
        System.out.println(list);
    }
}
