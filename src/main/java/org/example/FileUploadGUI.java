package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class FileUploadGUI extends Application {

    Tess tesseract = new Tess();
    Writer writer = new Writer();

    @Override
    public void start(Stage primaryStage) {
        // Створюємо кнопку для вибору файлу
        Button uploadButton = new Button("Завантажити файл");

        // Встановлюємо обробник подій для кнопки
        uploadButton.setOnAction(event -> {
            // Відкриваємо вікно вибору файлу
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Оберіть файл для завантаження");
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

            // Виконуємо дії з вибраним файлом (наприклад, виводимо шлях файлу)
            if (selectedFile != null) {

                //System.out.println("Вибраний файл: " + selectedFile.getAbsolutePath());
                writer.writeToTxt(tesseract.getText(selectedFile.getAbsolutePath()), selectedFile.getAbsolutePath());

            }
        });


        VBox root = new VBox(uploadButton);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Завантаження файлу");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

