package com.company;

import java.util.ArrayList;

public class TestCollection {
    public static void main(String[] args) {
        ArrayList heros = new ArrayList();
        heros.add(new Hero("盖伦"));
        System.out.println(heros.size());

        heros.add(new Hero("teemo"));
        System.out.println(heros.size());
    }
}
