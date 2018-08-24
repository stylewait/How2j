package com.company;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {
    public HeroNode leftNode;
    public HeroNode rightNode;
    public Hero value;

    public void add(Hero v) {
        if(null == value)
            value = v;
        else{
            if (v.hp > value.hp){
                if(null == leftNode)
                    leftNode = new HeroNode();
                leftNode.add(v);
            }
            else{
                if (null == rightNode)
                    rightNode = new HeroNode();
                rightNode.add(v);
            }

        }
    }

    public List<Object> values(){
        List<Object> values = new ArrayList<>();
        if(null != leftNode)
            values.addAll(leftNode.values());
        values.add(value);

        if (null != rightNode)
            values.addAll(rightNode.values());
        return values;
    }



    public static void main(String[] args) {
        List<Hero> hs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero h = new Hero();
            h.name = "hero" + i;
            h.hp = (int)(Math.random() * 900 + 100);
            hs.add(h);
        }
        System.out.println("初始化10个Hero");
        System.out.println(hs);

        HeroNode heroTree = new HeroNode();
        for (Hero hero : hs) {
            heroTree.add(hero);
        }
        System.out.println("根据血量倒排序后的Hero");
        List<Object> treeSortedHeros = heroTree.values();
        System.out.println(treeSortedHeros);
    }
}
