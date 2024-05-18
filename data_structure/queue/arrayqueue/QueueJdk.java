package data_structure.queue.arrayqueue;

import data_structure.Employee;

import java.util.LinkedList;
import java.util.Queue;

public class QueueJdk {
    public static void main(String[] args) {
        Queue<Employee> employeeQueue = new LinkedList<>();
        Employee salah = new Employee("Salah", "Abdelrahman", 4);
        Employee hussein = new Employee("Hussein", "Abdelrahman", 1);
        Employee lobna = new Employee("Lobna", "Abdelrahman", 3);
        Employee nour = new Employee("Nour", "Abdelrahman", 2);
        Employee oudi = new Employee("Oudi", "Amr", 5);

        employeeQueue.add(salah);
        employeeQueue.add(hussein);
        employeeQueue.add(lobna);
        employeeQueue.add(nour);
        employeeQueue.add(oudi);
        System.out.println(employeeQueue.peek());
        System.out.println();

        System.out.println(employeeQueue.poll());
        System.out.println(employeeQueue.poll());
    }
}
