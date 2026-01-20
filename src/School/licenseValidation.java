package School;

//Name: Ruan Viesti Moraes && Richard Ya ; Date: 11/06/2025
import java.util.Scanner;

public class licenseValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your surname: ");
        String surname = sc.nextLine();
        String surnameUpper = surname.toUpperCase();
        System.out.print("\nPlease enter your date of birth (yymmdd): ");
        String birthDate = sc.nextLine();
        System.out.print("\nPlease enter your drivers license number: ");
        String driverNum = sc.nextLine();
        boolean isComplete = driverNum.length() == 17;
        boolean isValidFormat = true;
        if (isComplete) {
            for (int i = 0; i < 17; i++) {
                char c = driverNum.charAt(i);

                if (i == 0) {
                    if (!Character.isLetter(c)) {
                        isValidFormat = false;
                        break;
                    }
                } else if (i == 5 || i == 11) {
                    if (c != '-') {
                        isValidFormat = false;
                        break;
                    }
                } else {
                    if (!Character.isDigit(c)) {
                        isValidFormat = false;
                        break;
                    }
                }
            }
        }
        if (isValidFormat && isComplete) {
            boolean rule3 = driverNum.charAt(0) == surnameUpper.charAt(0);
            boolean rule4 = driverNum.charAt(10) == birthDate.charAt(0);
            boolean rule5 = driverNum.substring(12, 17).equals(birthDate.substring(1, 6));

            if (!(rule3 && rule4 && rule5)) {
                isValidFormat = false;
            }
        }
        if (!isComplete) {
            System.out.println("Your driver license is INCOMPLETE!");
        } else if (isValidFormat) {
            System.out.println("Your driver license is VALID!");
        } else {
            System.out.println("Your driver license is INVALID!");
        }
        sc.close();
    }
}
