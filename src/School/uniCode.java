package School;

import java.util.Scanner;

public class uniCode {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a String:");

        String password = input.next();

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            int Decimal_value = password.codePointAt(i);

            System.out.printf("Character:%c\tUnicode value:0x0%X\tDecimal value:%d\n", ch, Decimal_value,
                    Decimal_value);

        }

        input.close();
    }
}
