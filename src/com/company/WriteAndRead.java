package com.company;

import java.io.*;

public class WriteAndRead {
    public static void main(String[] args) {
        write();
        read();
    }
    private static void read(){
        File f = new File("G:/LOLFolder/lol6.txt");
        try (FileInputStream fis = new FileInputStream(f);
             DataInputStream dis = new DataInputStream(fis)
        ) {
            boolean b = dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();

            //System.out.println("读取到布尔值：" + b);
            System.out.println("读取到整数：" + i);
            //System.out.println("读取到字符串：" + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(){
        File file = new File("G:/LOLFolder/lol6.txt");
        try(FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos)
        ){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
