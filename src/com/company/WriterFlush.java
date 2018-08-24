package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterFlush {
    public static void main(String[] args) {
        File file = new File("G:/LOLFolder/lol5.txt");
        try (FileWriter fw = new FileWriter(file);
             PrintWriter pw = new PrintWriter(fw)
        ) {
            pw.println("garen kill teemo");
            pw.flush();
            pw.println("teemo revive after 1 minute");
            pw.flush();
            pw.println("teemo try to garen,but killed again");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
