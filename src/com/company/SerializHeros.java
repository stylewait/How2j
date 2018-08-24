package com.company;

import java.io.*;

public class SerializHeros {
    public static void main(String[] args) {
        Hero[] heros = new Hero[10];
        for(int i = 0; i < heros.length; i++){
            heros[i] = new Hero("hero:" + i);
        }
        File file = new File("G:/LOLFolder/heros.lol");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(heros);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Hero[] heroes = (Hero[])ois.readObject();
            System.out.println("查看文件中反序列化出来的数组中的每一个元素：");
            for(Hero hero : heroes)
                System.out.println(hero.name);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
