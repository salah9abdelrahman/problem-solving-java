package data_structure.list.linkedlist.doublyLinkedList;

import data_structure.Employee;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        Employee salah = new Employee("Salah", "Abdelrahman", 4);
        Employee hussein = new Employee("Hussein", "Abdelrahman", 1);
        Employee lobna = new Employee("Lobna", "Abdelrahman", 3);
        Employee nour = new Employee("Nour", "Abdelrahman", 2);
        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(hussein);
        list.addToFront(lobna);
        list.addToFront(nour);

//        System.out.println(list.addBefore(salah, hussein));
        System.out.println(list.addBefore(salah, nour));
        System.out.println(list.addBefore(salah, new Employee("not", " exist", 32)));
        list.printList();

    }
}
