package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> resultTree = new LinkedList<String>();
        Stack<File> files = new Stack<>();
        files.push(new File(root));
        while (!files.isEmpty()) {
            File currentFule = files.pop();
            if (currentFule.isDirectory()) {
                for (File file : currentFule.listFiles()) {
                    files.push(file);
                }
            }
            if (currentFule.isFile())
                resultTree.add(currentFule.getAbsolutePath());
        }
        return resultTree;
    }

    public static void main(String[] args) {
        
    }
}
