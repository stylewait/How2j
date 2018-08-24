package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
//        try {
//            File f = new File("G:/LOLFolder/LOL.txt");
//            FileInputStream fis = new FileInputStream(f);
//
//            byte[] all = new byte[(int)(f.length())];
//
//            fis.read(all);
//            for (byte b : all) {
//                System.out.println(b);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try{
//            File file = new File("G:/LOLFolder/lol2.txt");
//            FileOutputStream fos = new FileOutputStream(file);
//
//            byte data[] = {88, 89};
//            fos.write(data);
//            fos.close();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        File file = new File("G:/LOLFolder/lol2.txt");
//        try(FileReader fr = new FileReader(file)){
//            char[] all = new char[(int)file.length()];
//            fr.read(all);
//            for (char c : all) {
//                System.out.println(c);
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
        File file = new File("G:/LOLFolder/lol2.txt");
        try (FileWriter fw = new FileWriter(file)) {
            String str = "abcdefg124567890";
            fw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
