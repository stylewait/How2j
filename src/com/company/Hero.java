package com.company;

import java.io.Serializable;
import java.util.Comparator;

public class Hero implements Serializable {
    private static final long serialVersionUID = 1L;
    public int id;
    public String name;
    public int hp;
    public int damage;

    public Hero(){}

    public  Hero(String name)
    {
        this.name = name;
    }

    public void attackHero(Hero h) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s 的血变成了 %.0f%n", name, h.name, h.name, h.hp);

        if (h.isDead()) {
            System.out.println(h.name + "死了！");
        }

    }
    public boolean isDead(){
        return 0 >= hp ? true : false;
    }

    @Override
    public String toString() {
        return String.format("[name : %s  hp : %.0f]%n", name, hp);
    }


}
