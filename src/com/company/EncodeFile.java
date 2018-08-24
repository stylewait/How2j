package com.company;

import java.io.*;

public class EncodeFile {
    public static void main(String[] args) {
        File enconding = new File("G:/LOLFolder/encoding/encoding.txt");
        File encoded = new File("G:/LOLFolder/encoding/encoded.txt");
        encodeFile(enconding, encoded);
    }

    public static void encodeFile(File encodingFile, File encodedFle){
        try (FileReader fr = new FileReader(encodingFile); FileWriter fw = new FileWriter(encodedFle)) {
            char[] in = new char[(int) encodingFile.length()];
            fr.read(in);
            int[] input = new int[in.length];
            for (int i = 0; i < in.length; i++) {
                input[i] = (int) in[i];
                if ((input[i] >= 48 && input[i] <= 56) || (input[i] >= 65 && input[i] <= 89) ||
                        (input[i] >= 97) && input[i] <= 121) {
                    input[i] = input[i] + 1;
                } else if ((input[i] == 57)) {
                    input[i] = 48;
                } else if (input[i] == 90 || input[i] == 122) {
                    input[i] = input[i] - 25;
                }
                in[i] = (char) input[i];
            }
            fw.write(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
