package studyMyself.methods.level1;

//Write a method that returns the bigger of two numbers.
public class biggerNum {

    public static void main(String[] args) {
        int a = 5;
        int b = 9;
        int bigger = nums(a, b);
        System.out.println("The bigger number is: " + bigger);
    }

    public static int nums(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}