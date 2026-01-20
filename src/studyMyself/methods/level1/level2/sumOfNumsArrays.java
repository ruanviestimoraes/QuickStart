package studyMyself.methods.level1.level2;

//Write a method that takes an int array and returns the sum of all elements.
public class sumOfNumsArrays {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int total = sumOfArrays(nums);
        System.out.println(total);

    }

    public static int sumOfArrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

        }
        return sum;

    }
}
