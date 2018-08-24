package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Hero> q = new LinkedList<Hero>();
        System.out.println("初始化队列： \t");
        q.offer(new Hero("Hero1"));
        q.offer(new Hero("Hero2"));
        q.offer(new Hero("Hero3"));
        q.offer(new Hero("Hero4"));

        System.out.println(q);
        System.out.println("把第一个元素取poll()出来：\t");
        Hero h = q.poll();
        System.out.println(h);
        System.out.println("取出第一个元素之后的队列： \t");
        System.out.println(q);

        h = q.peek();
        System.out.println("查看peek()第一个元素：\t");
        System.out.println(h);
        System.out.println("查看并不会导致第一个元素被取出来: \t");
        System.out.println(q);
    }
}
