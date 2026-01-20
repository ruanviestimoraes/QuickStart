package studyMyself.usingFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperationsExample {
    public static void main(String[] args) {
        String fileName = "myFile.txt";
        // Create a new file
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred during file creation.");
            e.printStackTrace();
        }
        // Write to the file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, Java file handling!");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred during writing.");
            e.printStackTrace();
        }
        // Read from the file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println("File content: " + data);
            }
        } catch (IOException e) {
            System.out.println("An error occurred during reading.");
            e.printStackTrace();
        }
        /*
         * // Delete the file
         * if (file.delete()) {
         * System.out.println("Deleted the file: " + file.getName());
         * } else {
         * System.out.println("Failed to delete the file.");
         * }
         */
    }
}