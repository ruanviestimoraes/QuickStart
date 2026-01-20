package studyMyself.methods.level1.level3;

import java.util.Scanner;

public class passwordChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (passwordRequirements(password)) {
                System.out.println("Password correct");
                isTrue = false;
            } else {
                System.out.println("Password incorrect");
            }
        }
        sc.close();
    }

    public static boolean passwordRequirements(String password) {
        if (password.length() >= 8 && password.matches(".*[!@?].*")) {
            return true;
        }
        return false;

    }
}
