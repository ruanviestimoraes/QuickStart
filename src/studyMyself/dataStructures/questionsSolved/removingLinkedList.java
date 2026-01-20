package studyMyself.dataStructures.questionsSolved;

import java.util.LinkedList;

//Create a LinkedList of integers. Insert some numbers. Remove all numbers greater than 10. Print the result.

public class removingLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> nums = new LinkedList<>();

        nums.add(12);
        nums.add(12);
        nums.add(12);
        nums.add(1);
        nums.add(2);
        nums.add(3);

        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) > 10) {
                nums.remove(i);
            }
        }
        System.out.println(nums);
    }

}
