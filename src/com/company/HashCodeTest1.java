package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HashCodeTest1 {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();
        for(int j = 0; j < 2000000; j++){
            Hero h = new Hero("Hero " + j);
            heros.add(h);
        }

        for (int i = 0; i < 10; i++) {
            Collections.shuffle(heros);
            long start = System.currentTimeMillis();
            String target = "Hero 1000000";
            for (Hero hero : heros) {
                if (hero.name.equals(target)) {
                    System.out.println("找到了hero");
                    break;
                }
            }
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("一共花了： " + elapsed + " 毫秒");
        }
    }
}
