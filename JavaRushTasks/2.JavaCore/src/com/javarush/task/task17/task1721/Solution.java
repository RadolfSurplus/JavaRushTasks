package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first_file = reader.readLine();
        String second_file = reader.readLine();
        reader = new BufferedReader(new FileReader(first_file));
        while (reader.ready()) {
            allLines.add(reader.readLine());
        }
        reader = new BufferedReader(new FileReader(second_file));
        while (reader.ready()) {
            forRemoveLines.add(reader.readLine());
        }
        reader.close();
        new Solution().joinData();
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

}
