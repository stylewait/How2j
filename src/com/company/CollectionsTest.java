package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("集合中的数据：");
        System.out.println(numbers);

//        Collections.reverse(numbers);
//        System.out.println("翻转后集合中的数据：");
//        System.out.println(numbers);
        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据：");
        System.out.println(numbers);

        Collections.sort(numbers);
        System.out.println("排序后集合中的数据：");
        System.out.println(numbers);

//        Collections.swap(numbers, 0, 5);
//        System.out.println("交换0和5下标的数据后，集合中的数据：");
//        System.out.println(numbers);

        Collections.rotate(numbers, 3);
        System.out.println("把集合向右滚动3个单位下标的数据后，集合中的数据：");
        System.out.println(numbers);

    }
}
