package studyMyself.dataStructures.questionsSolved;

//Write a method that takes an array of integers and returns the largest number and its index

public class biggestNumArray {

    public static int[] findLargestAndIndex(int[] numbers) {

        int largestIndex = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[largestIndex]) {
                largestIndex = i;
            }
        }

        int largestValue = numbers[largestIndex];

        return new int[] { largestValue, largestIndex };
    }

    public static void main(String[] args) {
        int[] numbers = { 5, 3, 9, 7, 0, 1 };

        int[] result = findLargestAndIndex(numbers);

        System.out.printf("Biggest number in this array is %d and its index is %d", result[0], result[1]);
    }

}
