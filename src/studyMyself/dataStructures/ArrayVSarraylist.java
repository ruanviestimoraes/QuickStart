package studyMyself.dataStructures;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayVSarraylist {
    public static void main(String[] args) {

        // Array
        String[] friendArray = { "john", "erik", "juan", "ruan" };

        System.out.println(friendArray[2]);
        System.out.println(friendArray.length);
        friendArray[0] = "Hee";

        // Array list
        ArrayList<String> friendArrayList = new ArrayList<>(Arrays.asList("john", "erik", "juan", "ruan"));

        System.out.println(friendArrayList.get(2));
        System.out.println(friendArrayList.size());
        friendArrayList.add("Mitch");

        for (int i = 0; i < (friendArrayList.size()); i++) {
            System.out.print(friendArrayList.get(i) + " ");
        }
        System.out.println();
        friendArrayList.set(0, "hee");

        for (int i = 0; i < (friendArrayList.size()); i++) {
            System.out.print(friendArrayList.get(i) + " ");
        }
        System.out.println();
        friendArrayList.remove(3);
        for (int i = 0; i < (friendArrayList.size()); i++) {
            System.out.print(friendArrayList.get(i) + " ");
        }
        System.out.println();

        for (int i = (friendArrayList.size() - 1); i >= 0; i--) {
            System.out.print(friendArrayList.get(i) + " ");

        }

    }
}
