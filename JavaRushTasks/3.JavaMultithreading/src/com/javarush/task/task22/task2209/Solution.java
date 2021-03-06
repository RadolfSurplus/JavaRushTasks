package com.javarush.task.task22.task2209;

import java.io.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        String fileName;

        BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = cbr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String line = "";
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            while ((line = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        line = sb.toString();

        StringBuilder result = getLine(line.split("\\s+"));
        System.out.println(result.toString());
    }


    public static StringBuilder getLine(String... words) {


        StringBuilder sb = new StringBuilder();

        if (words == null || words.length == 0) {
            return sb;
        }

        sb.append(words[0]);
        words[0] = "";

        if (words.length == 1) {
            return sb;
        }

        char strFirstChar = Character.toUpperCase(sb.charAt(0));
        char strLastChar = Character.toUpperCase(sb.charAt(sb.length() - 1));

        while (true) {
            int addedCount = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 0) {
                    if (firstChar(words[i]) == strLastChar) {
                        sb.append(" " + words[i]);
                        words[i] = "";
                        strLastChar = Character.toUpperCase(sb.charAt(sb.length() - 1));
                        addedCount++;
                    } else if (lastChar(words[i]) == strFirstChar) {
                        sb.insert(0, words[i] + " ");
                        words[i] = "";
                        strFirstChar = Character.toUpperCase(sb.charAt(0));
                        addedCount++;
                    }
                }
            }
            if (addedCount == 0) {
                break;
            }
        }

        for (String word : words) {
            if (word.length() > 0) {
                sb.append(" " + word);
            }
        }

        return sb;
    }


    public static char firstChar(String str) {
        return str.substring(0, 1).toUpperCase().charAt(0);
    }


    public static char lastChar(String str) {
        return str.substring(str.length() - 1).toUpperCase().charAt(0);
    }

}