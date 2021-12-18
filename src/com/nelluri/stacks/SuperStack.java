package com.nelluri.stacks;

/*
Super stack supports the following operations.
Push: O(1)
Pop: O(1)
findMax: O(1)
 */
public class SuperStack {
    StackUsingLL stack;
    StackUsingLL stackMax;

    SuperStack() {
        stack = new StackUsingLL();
        stackMax = new StackUsingLL();
    }
    public void push(int element) {
        stack.push(element);
        if(stackMax.size == 0) {
            stackMax.push(element);
        } else if(stackMax.size > 0 && element > stackMax.peek()) {
            stackMax.push(element);
        }
    }

    public int pop() {
        if(stack.size == 0) {
            return -1;
        }
        int data = stack.pop();
        if(stackMax.size > 0 && data >= stackMax.peek()) {
            stackMax.pop();
        }
        return data;
    }

    public int findMax() {
        if(stackMax.size == 0) {
            return -1;
        }
        return stackMax.peek();
    }
    public static void main(String[] args) {
        SuperStack superStack = new SuperStack();
        superStack.push(10);
        superStack.push(5);
        superStack.push(20);
        superStack.push(1);
        superStack.push(30);
        superStack.push(100);
        System.out.println("Max element is " + superStack.findMax());
        superStack.pop();
        superStack.pop();
        superStack.pop();
        System.out.println("Max element is " + superStack.findMax());
        superStack.pop();
        System.out.println("Max element is " + superStack.findMax());

    }
}
