package data_structure.list.linkedlist.singlyLinkedlList;

import data_structure.Employee;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        Employee salah = new Employee("Salah", "Abdelrahman", 4);
        Employee hussein = new Employee("Hussein", "Abdelrahman", 1);
        Employee lobna = new Employee("Lobna", "Abdelrahman", 3);
        Employee nour = new Employee("Nour", "Abdelrahman", 2);

        EmployeeSinglyLinkedList list = new EmployeeSinglyLinkedList();
//        System.out.println(list.isEmpty());
//
//        list.addToFront(salah);
//        list.addToFront(hussein);
//        list.addToFront(lobna);
//        list.addToFront(nour);
//        System.out.println(list.isEmpty());
//
//        System.out.println(list.removeFromFront());
//        System.out.println(list.getSize());

        list.insertSortedById(nour);
        list.insertSortedById(hussein);
        list.insertSortedById(lobna);
//        list.printList();
        list.insertSortedById(salah);
        list.printList();




    }
}
