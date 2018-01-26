package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in=new FileInputStream(args[1]);
        FileOutputStream out=new FileOutputStream(args[2]);
        byte []x=new byte[in.available()];
        in.read(x);
        if(args[0].equals("-e"))
            crypto(x);
        else
            crypto(x);
        out.write(x);
        out.flush();
        in.close();
        out.close();
    }

    private static void crypto(byte[] x) {
        byte temp=0;
        for(int i=0;i<x.length/2;i++){
            temp=x[i];
            x[i]=x[x.length-1-i];
            x[x.length-1-i]=temp;
        }
    }

}
