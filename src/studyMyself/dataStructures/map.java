package studyMyself.dataStructures;

import java.util.HashMap;

public class map {
    public static void main(String[] args) {
        HashMap<String, Integer> empIds = new HashMap<>(); // store things to other not in order when printed

        empIds.put("John", 12345);
        empIds.put("Aaron", 54321);
        empIds.put("Alina", 98760);

        System.out.println(empIds);

        System.out.println(empIds.get("Aaron")); // get his ID

        System.out.println(empIds.containsKey("Alina"));

        System.out.println(empIds.containsValue(12345));

        empIds.put("John", 76543); // updates

        System.out.println(empIds);

        empIds.replace("John", 999); // also updates however if
                                     // i dont have an already existing
                                     // value it will not create a ne one instead of put

        System.out.println(empIds);

        empIds.putIfAbsent("Diego", 99876); // only adds if not in the map already
        empIds.putIfAbsent("John", 999);

        System.out.println(empIds);

        empIds.remove("Diego");

        System.out.println(empIds);

    }

}
