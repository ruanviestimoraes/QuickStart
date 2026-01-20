package studyMyself.dataStructures;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class queue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<people> superMarket = new LinkedList<>();

        boolean a = true;

        while (a) {
            System.out.print("Want to add? (y / n)  ");
            String user = sc.next();

            if (user.equalsIgnoreCase("y")) {
                System.out.print("Enter name: ");
                String name = sc.next();

                System.out.print("Enter age ");
                int age = sc.nextInt();

                superMarket.add(new people(name, age));

                continue;
            } else if (user.equalsIgnoreCase("n")) {
                System.out.print("Bye");
                a = false;

            }
            System.out.println(superMarket); // shows the whole queue
            System.out.println(superMarket.peek()); // shows the first element in the queue
            superMarket.poll(); // removes the first element in the queue
            System.out.println(superMarket.size()); // shows the size of the queue

        }

        sc.close();
    }

    static record people(String name, int age) {
    }
}
