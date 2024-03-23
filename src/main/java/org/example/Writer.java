package org.example;


import java.io.FileWriter;
import java.io.IOException;


public class Writer {

    public void writeToTxt(String text, String path) {

        String outputPath = changeFileExtension(path);

        try (FileWriter writer = new FileWriter(outputPath)) {

            writer.write(text);
            //System.out.println("Розпізнаний текст успішно збережено у файл .txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String changeFileExtension(String filePath) {
        int dotIndex = filePath.lastIndexOf('.');
        if (dotIndex != -1) {

            return filePath.substring(0, dotIndex) + "." + "txt";
        } else {

            return filePath + "." + "txt";
        }
    }

}