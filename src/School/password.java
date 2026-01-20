package School;

import java.util.Scanner;

public class password {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your password: ");
        String password = input.nextLine();

        boolean hasMinLength = password.length() >= 8;
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasNoSpaces = !password.contains(" ");

        if (hasMinLength && hasUppercase && hasLowercase && hasDigit && hasNoSpaces) {
            System.out.println("valid");
        } else {
            System.out.println("not valid");
        }

        input.close();
    }
}
