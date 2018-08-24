package com.company;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }
        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {
            Integer i = (Integer)iterator.next();
            System.out.println(i);
        }
        System.out.println("------");
        for (Integer i : numbers) {
            System.out.println(i);
        }
    }
}
