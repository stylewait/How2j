package com.company;

import java.util.ArrayList;

public class TestCollection2 {
    public static void main(String[] args) {
        ArrayList heros = new ArrayList();

        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero" + i));
        }
        Hero specialHero = new Hero("Special hero");
        heros.add(specialHero);

        System.out.println(heros);
        System.out.println("把下标是5的元素，替换为\"hero 5\"");
        heros.set(5, new Hero("hero 5"));
        System.out.println(heros);
    }
}
