package studyMyself.methods.level1.level2;

import java.util.Scanner;

// Write a method that checks whether a string contains only vowels.
public class onlyVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a word ");
            String word = sc.nextLine();

            if (word.equals("break")) {
                break;
            } else if (vowelsOnly(word)) {
                System.out.println("Only vowels");
            } else {
                System.out.println("Not only vowels");
            }

        }
        sc.close();
    }

    public static boolean vowelsOnly(String word) {
        if (word == null) {
            return false;
        }
        return word.toLowerCase().matches("[aeiou]+");

    }

}
