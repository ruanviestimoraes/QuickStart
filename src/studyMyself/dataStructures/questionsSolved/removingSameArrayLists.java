package studyMyself.dataStructures.questionsSolved;

import java.util.ArrayList;

public class removingSameArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(3);
        nums.add(8);
        nums.add(2);
        nums.add(3);
        nums.add(2);
        nums.add(1);

        System.out.println("Original list: " + nums);

        // Outer loop — pick each number
        for (int i = 0; i < nums.size(); i++) {
            int current = nums.get(i);

            // Inner loop — count occurrences (backward)
            for (int j = nums.size() - 1; j >= 0; j--) {
                if (nums.get(j) == current) {

                    nums.remove(j);
                }
            }
        }

        System.out.println("List after removing duplicates: " + nums);

    }
}
