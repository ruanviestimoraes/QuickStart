package School;

public class mergeSort {
    public static void main(String[] args) {

        int[] arr1 = new int[500];
        int[] arr2 = new int[5000];
        int[] arr3 = new int[50000];
        int[] arr4 = new int[500000];

        int maxValue = 100;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * maxValue);

        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * maxValue);

        }

        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int) (Math.random() * maxValue);

        }

        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = (int) (Math.random() * maxValue);

        }

        long startTime = System.nanoTime();
        mergeSorting(arr1);
        long endTime = System.nanoTime();
        System.out.println("First Array time: " + (endTime - startTime));

        startTime = System.nanoTime();
        mergeSorting(arr2);
        endTime = System.nanoTime();
        System.out.println("Second Array time: " + (endTime - startTime));

        startTime = System.nanoTime();
        mergeSorting(arr3);
        endTime = System.nanoTime();
        System.out.println("Third Array time: " + (endTime - startTime));

        startTime = System.nanoTime();
        mergeSorting(arr4);
        endTime = System.nanoTime();
        System.out.println("Forth Array time: " + (endTime - startTime));

    }

    // use recursive method
    private static void mergeSorting(int[] arr) {
        int length = arr.length;

        if (length <= 1)
            return; // base case

        int middle = length / 2;

        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; // left array
        int j = 0; // rigth array

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = arr[i];

            } else {
                rightArray[j] = arr[i];
                j++;
            }
        }

        mergeSorting(leftArray);
        mergeSorting(rightArray);
        merge(leftArray, rightArray, arr);

    }

    private static void merge(int[] leftArray, int[] rightArray, int[] arr) {

        int leftSize = arr.length / 2;
        int rigthSize = arr.length - leftSize;
        int i = 0, l = 0, r = 0; // indices

        // check conditions for merging

        while (l < leftSize && r < rigthSize) {
            if (leftArray[l] < rightArray[r]) {
                arr[i] = leftArray[l];
                i++;
                l++;

            } else {
                arr[i] = rightArray[r];
                i++;
                r++;

            }
        }
        while (l < leftSize) {
            arr[i] = leftArray[l];
            i++;
            l++;

        }
        while (r < rigthSize) {
            arr[i] = rightArray[r];
            i++;
            r++;

        }

    }

}
