package data_structure.list.stack.arraystack;

import data_structure.Employee;

import java.util.EmptyStackException;

/*
    Not ideal
 */
public class ArrayStack {
    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    // o(n) because if the resizing
    public void push(Employee employee) {
        // stack is full so resize
        if (top == stack.length) {
            Employee[] newArray = new Employee[stack.length * 2];
            System.arraycopy(this.stack, 0, newArray, 0, this.stack.length);
            stack = newArray;
        }
        stack[top++] = employee;
    }

    /*
    // we can resize the array to avoid wasted memory but we will make it o(n)
     */
    // o(1)
    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public void printStack() {
        for (int i = top -1; i >= 0 ; i--) {
            System.out.println(stack[i]);
        }
    }

}
