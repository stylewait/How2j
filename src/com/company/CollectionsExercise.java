package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExercise {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            Collections.shuffle(numbers);
            if (numbers.get(0) == 3 && numbers.get(1) == 1 && numbers.get(2) == 4) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println((double)count/1000000);

    }
}
