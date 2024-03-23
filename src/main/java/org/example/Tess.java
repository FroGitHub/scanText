package org.example;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Tess {
    private static Tesseract tesseract;
    private static File imgFile;

    public static String getText(String input) {


        tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/Tesseract-OCR/tessdata");

        imgFile = new File(input);

        tesseract.setLanguage("ukr");
        tesseract.setPageSegMode(4);
        tesseract.setOcrEngineMode(1);
        tesseract.setTessVariable("preserve_interword_spaces", "1");

        try {

            String fullText = tesseract.doOCR(imgFile);
            return fullText;
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return "None";
    }
}