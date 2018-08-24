package com.company;

import java.util.LinkedList;

public class LinkedTest {
    public static void main(String[] args) {
        LinkedList<Hero> ll = new LinkedList<Hero>();

        ll.addLast(new Hero("hero1"));
        ll.addLast(new Hero("hero2"));
        ll.addLast(new Hero("hero3"));
        System.out.println(ll);

        ll.addFirst(new Hero("heroX"));
        System.out.println(ll);

        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());

        System.out.println(ll);

        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());
        System.out.println(ll);
    }
}
