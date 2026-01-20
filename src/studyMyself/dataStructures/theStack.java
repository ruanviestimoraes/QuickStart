package studyMyself.dataStructures;

import java.util.Stack;

public class theStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.print(stack.peek());
        System.out.print(stack.size());
        System.out.print(stack.pop());

    }
}
