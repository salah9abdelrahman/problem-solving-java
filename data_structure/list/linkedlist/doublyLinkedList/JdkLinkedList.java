package data_structure.list.linkedlist.doublyLinkedList;

import data_structure.Employee;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class JdkLinkedList {
    public static void main(String[] args) {
        Employee salah = new Employee("Salah", "Abdelrahman", 4);
        Employee hussein = new Employee("Hussein", "Abdelrahman", 1);
        Employee lobna = new Employee("Lobna", "Abdelrahman", 3);
        Employee nour = new Employee("Nour", "Abdelrahman", 2);
        LinkedList<Employee> list = new LinkedList<>();
        list.addLast(hussein);
        list.addFirst(salah);

        // same ass addEnd()
        list.add(lobna);
        list.addFirst(nour);

        //remove from front same as list.removeFirst()
        list.remove();



        list.forEach(System.out::println);


    }
}
