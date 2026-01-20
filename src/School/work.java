package School;

import java.util.Scanner;

public class work {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int letterCount = 0;
        int digitCount = 0;
        int spaceCount = 0;

        System.out.println("Enter a mixed string (letters and digits):");
        String mixedString = sc.nextLine();

        for (int i = 0; i < mixedString.length(); i++) {
            char currentChar = mixedString.charAt(i);

            if (Character.isLetter(currentChar)) {
                letterCount++;
            } else if (Character.isDigit(currentChar)) {
                digitCount++;
            } else if (Character.isWhitespace(currentChar)) {
                spaceCount++;

            }

        }
        System.out.println(" In \"" + mixedString + "\": Letters = " + letterCount + ", Digits = " + digitCount
                + ", Spaces = " + spaceCount);
        sc.close();
    }
}
