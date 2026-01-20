package studyMyself.usingFiles;

import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class testingFiles {
    public static void main(String[] args) {
        HashMap<String, Integer> nameAge = new HashMap<>();

        nameAge.put("Kaan", 17);
        nameAge.put("Ruan", 17);
        nameAge.put("SomeoneMother", 43);

        Scanner sc = new Scanner(System.in);

        System.out.print("enter name: ");
        String name = sc.nextLine();

        System.out.print("enter age: ");
        int age = sc.nextInt();

        nameAge.put(name, age);

        sc.close();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("namesAges.txt"));

            for (String stuff : nameAge.keySet()) {
                writer.write(stuff + ": " + nameAge.get(stuff) + "\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("namesAges.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
