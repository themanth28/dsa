package StackAndQueue;

import java.util.Stack;

public class MinStack {
    private final Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long) val);
            min = val;
        } else {
            if (val < min) {
                // Encode the value and push
                stack.push(2L * val - min);
                min = val;
            } else {
                stack.push((long) val);
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long top = stack.pop();
        if (top < min) {
            // Recover previous minimum
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < min) {
            // Encoded value, so real top is current min
            return (int) min;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        return (int) min;
    }

    // Example test
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(2);
        minStack.push(4);
        System.out.println("Min: " + minStack.getMin()); // 2
        System.out.println("Top: " + minStack.top());    // 4
        minStack.pop();
        System.out.println("Min: " + minStack.getMin()); // 2
        minStack.pop();
        System.out.println("Min: " + minStack.getMin()); // 3
        minStack.pop();
        System.out.println("Top: " + minStack.top());    // 5
        System.out.println("Min: " + minStack.getMin()); // 5
    }
}
