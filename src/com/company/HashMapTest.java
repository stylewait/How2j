package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapTest {
    public static void main(String[] args) {
//        HashMap<String, String> dictionary = new HashMap<>();
//        dictionary.put("adc", "物理英雄");
//        dictionary.put("apc", "魔法英雄");
//        dictionary.put("tank", "坦克");
//
//        System.out.println(dictionary.get("tank"));
        HashMap<String, Hero> heroMap = new HashMap<>();
        heroMap.put("gareen", new Hero("gareen1"));
        System.out.println(heroMap);

        heroMap.put("gareen", new Hero("gareen2"));
        System.out.println(heroMap);

        heroMap.clear();
        Hero gareen = new Hero("gareen");

        heroMap.put("hero1", gareen);
        heroMap.put("hero2", gareen);

        System.out.println(heroMap);
    }
}
