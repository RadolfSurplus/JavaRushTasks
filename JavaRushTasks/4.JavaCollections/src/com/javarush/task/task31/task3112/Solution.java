package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL newURL = new URL(urlString);
        InputStream inputStream = newURL.openStream();

        Path tempFile = Files.createTempFile("temp",".tmp");
        Files.copy(inputStream, tempFile);
        String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
        Path downloadFile = Paths.get(downloadDirectory + "/" + fileName);
        Files.move(tempFile, downloadFile);
        return downloadFile;
    }
}
