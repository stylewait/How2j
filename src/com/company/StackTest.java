package com.company;

import java.util.LinkedList;
import java.util.Stack;

public class StackTest /*extends Stack*/{
    LinkedList<Hero> heros = new LinkedList<Hero>();

    public void push(Hero h) {
        heros.addLast(h);
    }

    public Hero pull(){
        return heros.removeLast();
    }

    public Hero peek(){
        return heros.getLast();
    }


    public static void main(String[] args) {
        StackTest heroStack = new StackTest();
        for (int i = 0; i < 5; i++) {
            Hero h = new Hero("hero name: " + i);
            System.out.println("压入 hero: " + h);
            heroStack.push(h);
        }
        System.out.println("--------------");
        for (int i = 0; i < 5; i++) {
            Hero h = heroStack.pull();
            System.out.println("弹出 hero: " + h);
        }
    }
}
