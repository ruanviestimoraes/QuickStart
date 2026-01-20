package studyMyself.dataStructures.questionsSolved;

import java.util.ArrayList;

//Add numbers from 1–20 to an ArrayList, then remove all even numbers. Print the result.
public class sumOfNumsArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i < 21; i++) {
            nums.add(i);
        }

        for (int j = nums.size() - 1; j > +0; j--) {
            if (nums.get(j) % 2 == 0) {
                nums.remove(j);
            }
        }

        int sum = 0;
        for (int k = 0; k < nums.size(); k++) {
            sum += nums.get(k);
        }
        System.out.println("the list: " + nums + " their sum: " + sum);
    }
}
