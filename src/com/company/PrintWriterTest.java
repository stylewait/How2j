package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) {
        File file = new File("G:/LOLFolder/lol4.txt");
        try (FileWriter fw = new FileWriter(file);
             PrintWriter pw = new PrintWriter(fw)
        ) {
            pw.println("garen kill teemo");
            pw.println("teemo revive after 1 minutes");
            pw.println("teemo try to garen, but killed again");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
