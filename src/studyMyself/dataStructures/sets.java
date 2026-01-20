package studyMyself.dataStructures;

import java.util.HashSet;
import java.util.Set;

public class sets {
    public static void main(String[] args) {

        Set<String> names = new HashSet<>(); // cannot have duplicates

        names.add("Walter");
        names.add("Walter Jr");
        names.add("Jesse");
        names.add("Skyler");
        names.add("Gus");

        names.remove("Jesse");

        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.contains("Walter"));
        System.out.println("\n\n");
        for (String name : names) {
            System.out.println(name);
        }

        names.clear();

        System.out.println(names);

    }

}
