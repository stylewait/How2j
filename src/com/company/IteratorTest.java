package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<Hero>();
        for(int i = 0; i < 5; i++){
            heros.add(new Hero("hero name: " + i));
        }

        System.out.println("----使用while的iterator-----");
        Iterator<Hero> it = heros.iterator();
        while (it.hasNext()) {
            //Hero h = it.next();
            System.out.println(it.next());

        }
        System.out.println("-----使用for的iterator");
        for (Iterator<Hero> iterator = heros.iterator(); iterator.hasNext();) {
            Hero hero = (Hero) iterator.next();
            System.out.println(hero);
        }
        System.out.println("-----增强for循环-----");
        for (Hero h : heros) {
            System.out.println(h);
        }
    }
}
