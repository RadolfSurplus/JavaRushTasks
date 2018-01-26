package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        boolean first = true;
        while (br.ready()){
            String curStr = br.readLine();
            for (String val:curStr.split(" ")){
                if (val.length()>6){
                    if(!first) bw.write(",");
                    bw.write(val);
                    first = false;
                }
            }

        }
        br.close();
        bw.close();
    }
}
