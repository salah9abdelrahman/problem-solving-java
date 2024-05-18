package data_structure.queue.arrayqueue;

import data_structure.Employee;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayQueueMain {
    public static void main(String[] args) {
        Employee salah = new Employee("Salah", "Abdelrahman", 4);
        Employee hussein = new Employee("Hussein", "Abdelrahman", 1);
        Employee lobna = new Employee("Lobna", "Abdelrahman", 3);
        Employee nour = new Employee("Nour", "Abdelrahman", 2);
        Employee oudi = new Employee("Oudi", "Amr", 5);

        ArrayQueue arrayQueue = new ArrayQueue(5);

        // now with circular implementation, the queue wouldn't resize
        arrayQueue.add(oudi);
        arrayQueue.add(salah);
        arrayQueue.remove();
        arrayQueue.add(lobna);
        arrayQueue.remove();
        arrayQueue.add(nour);
        arrayQueue.remove();
        arrayQueue.add(hussein);
        arrayQueue.remove();
        arrayQueue.add(oudi);
        arrayQueue.printQueue();


        Queue<Employee> employeeQueue = new LinkedList<>();
        employeeQueue.size();




    }
}
