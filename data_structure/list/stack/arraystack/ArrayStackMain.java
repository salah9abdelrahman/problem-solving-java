package data_structure.list.stack.arraystack;

import data_structure.Employee;

public class ArrayStackMain {
    public static void main(String[] args) {
       ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(new Employee("Salah", "Abdelrahman", 4));
        arrayStack.push(new Employee("Hussein", "Abdelrahman", 1));
        arrayStack.push(new Employee("Lobna", "Abdelrahman", 3));
        arrayStack.push( new Employee("Nour", "Abdelrahman", 2));

        arrayStack.pop();
        System.out.println(arrayStack.peek());

        arrayStack.printStack();
    }
}
