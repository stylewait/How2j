package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionsExercise2 {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        boolean i = true;
        while (i) {
            numbers.add((int)(Math.random() * 1000));
            if(numbers.size() == 50)
                i =false;
        }
        System.out.println(numbers);
    }
}
