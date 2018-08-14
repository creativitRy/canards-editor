package com.cloudcanards.canardseditor;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * TestFormatter
 *
 * @author ctRy
 */
public class TestFormatter extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Scanner in = new Scanner(System.in);

        File file = getFile();
        if (file == null)
            return;

        Scanner fileScanner = new Scanner(file);

        ArrayList<String> sb = new ArrayList<>();

        String prev = null;
        while (fileScanner.hasNext())
        {
            String line = fileScanner.nextLine();

            System.out.println(prev);
            System.out.println(line);

            System.out.print("Num Spaces: ");
            if (in.hasNextInt())
            {
                int numSpaces = in.nextInt();
                char[] arr = new char[numSpaces];
                Arrays.fill(arr, ' ');
                line = new String(arr) + line.replaceAll("^\\s+", "");
            }
            else
            {
                in.next();
            }
            sb.add(line);

            prev = line;
        }

        File file1 = saveFile();
        if (file1 == null)
            return;
        Files.write(Paths.get(file1.getPath()), sb, Charset.forName("UTF-8"));
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    private static File getFile()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file");
        return fileChooser.showOpenDialog(null);
    }

    private static File saveFile()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file");
        return fileChooser.showSaveDialog(null);
    }
}
