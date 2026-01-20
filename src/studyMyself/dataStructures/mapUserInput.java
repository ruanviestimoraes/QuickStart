package studyMyself.dataStructures;

import java.util.HashMap;
import java.util.Scanner;

public class mapUserInput {
    public static void main(String[] args) {
        HashMap<String, Integer> test = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter name (or -1 to stop): ");
            String name = sc.nextLine();

            if (name.equals("-1")) {
                break;
            }

            System.out.print("Enter age: ");
            try {
                int age = Integer.parseInt(sc.nextLine());
                test.put(name, age);
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Please enter a number.");
            }

        }

        sc.close();
        System.out.println(test);
    }

}
