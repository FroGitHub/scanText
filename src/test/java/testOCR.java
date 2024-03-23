import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.nio.charset.StandardCharsets;


public class testOCR {

    private static Tesseract tesseract;
    private static File imgFile;

    @BeforeAll
    @DisplayName("Check path")
    public static void checkPath(){
        String input = "src/main/resources/test-photo.png";

        tesseract = new Tesseract();
        tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");

        imgFile = new File(input);

        tesseract.setLanguage("eng+ukr");
        tesseract.setPageSegMode(6);
        tesseract.setOcrEngineMode(1);

    }

    @Test
    @DisplayName("read from photo")
    public void testToReadFromPhoto(){
        try {

            String fullText = tesseract.doOCR(imgFile);
            System.out.println(fullText);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
