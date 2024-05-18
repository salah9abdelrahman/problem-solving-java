package data_structure.list.stack.linkedstack;

import data_structure.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack <T> {
    private final LinkedList<T> stack;

    public LinkedStack() {
        this.stack = new LinkedList<>();
    }

    public void push(T t) {
        stack.push(t);
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack(){
        ListIterator<T> listIterator = stack.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
    }
}
