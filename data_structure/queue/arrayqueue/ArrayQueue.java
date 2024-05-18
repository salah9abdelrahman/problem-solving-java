package data_structure.queue.arrayqueue;

import data_structure.Employee;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    // o(n) because if the resizing
    public void add(Employee employee) {
        // queue is full so resize
        if (size() == queue.length - 1) {
            int numItems = size();
            Employee[] newArray = new Employee[queue.length * 2];
            // organize the items
            System.arraycopy(this.queue, front, newArray, 0, queue.length - front);
            System.arraycopy(this.queue, 0, newArray, queue.length - front, back);
            queue = newArray;
            front = 0;
            back = numItems;
        }

        this.queue[back] = employee;

        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public Employee remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Employee employee = queue[front];
        queue[front] = null;
        front++;

        //optimization
        if (isEmpty()) {
            front = 0;
            back = 0;
        }
        else if(front == queue.length){
            front = 0;
        }
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }


    public boolean isEmpty() {
        return ((back - front) == 0);
    }

    public int size() {
        //queue got wrapped
        if(front > back){
            return back - front + queue.length;
        }
        return back - front;
    }

    public void printQueue() {
        //queue got wrapped
        if(front > back){
            for (int i = front; i <queue.length ; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }



}
