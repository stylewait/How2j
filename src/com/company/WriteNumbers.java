package com.company;

import java.io.*;

public class WriteNumbers {
    public static void main(String[] args){
        write();
        read();
    }
    private static void write() {
        File file = new File("G:/LOLFolder/lol7.txt");

        try (
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream dos = new DataOutputStream(fos)
        ) {
            dos.writeInt(31);
            dos.writeInt(15);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(){
        File file = new File("G:/LOLFolder/lol7.txt");
        try (FileInputStream fis = new FileInputStream(file);
             DataInputStream dis = new DataInputStream(fis)
        ) {
            int a = dis.readInt();
            int b = dis.readInt();
            System.out.println("读取到的第一个整数：" + a);
            System.out.println("读取到的第二个整数：" + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
