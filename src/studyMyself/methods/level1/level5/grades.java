package studyMyself.methods.level1.level5;

import java.util.HashMap;
import java.util.Scanner;

public class grades {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> nameGrade = new HashMap<>();

        HashMap<String, Integer> gradesToCalculate = readGrades(sc, nameGrade);
        double average = calculateAverage(gradesToCalculate);
        printReports(gradesToCalculate, average);

        sc.close();
    }

    // Reads grades from user
    public static HashMap<String, Integer> readGrades(Scanner sc, HashMap<String, Integer> nameGrade) {

        System.out.print("How many students? ");
        int numStudents = sc.nextInt();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.print("Enter average grade: ");
            int grade = sc.nextInt();
            nameGrade.put(name, grade);
        }

        return nameGrade;

    }

    // Calculates average of the array
    public static double calculateAverage(HashMap<String, Integer> nameGrades) {
        int sum = 0;
        for (int grade : nameGrades.values()) {
            sum += grade;
        }
        return (double) sum / nameGrades.size();
    }

    // Prints average and each grade status
    public static void printReports(HashMap<String, Integer> nameGrades, double average) {
        System.out.println("\nGrades of students:");
        for (int i = 0; i < nameGrades.size(); i++) {
            System.out.println("Student: " + nameGrades.keySet().toArray()[i] + " Grade #" + (i + 1) + ": "
                    + nameGrades.values().toArray()[i]);
        }
        System.out.printf("Average: %.2f%n", average);
    }
}
