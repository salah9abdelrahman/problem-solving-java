package data_structure.list.linkedlist.singlyLinkedlList;

import data_structure.Employee;

public class EmployeeSinglyLinkedList {
    private EmployeeSinglyNode head;
    private int size;

    // o(1)
    public void addToFront(Employee employee) {
        size++;
        EmployeeSinglyNode node = new EmployeeSinglyNode(employee);
        node.setNext(head);
        head = node;
    }

    // o(1)
    public EmployeeSinglyNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        size--;
        EmployeeSinglyNode removedItem = head;
        head = head.getNext();
        removedItem.setNext(null);
        return removedItem;
    }

    public void printList() {
        EmployeeSinglyNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public void insertSortedById(Employee newEmployee) {
        if (isEmpty() || head.getCurrent().getId() >= newEmployee.getId()) {
            addToFront(newEmployee);
        } else {
            EmployeeSinglyNode newNode = new EmployeeSinglyNode(newEmployee);
            EmployeeSinglyNode previous = head;
            EmployeeSinglyNode currentNode = head.getNext();
            while (currentNode != null) {
                // insert at the end
                if (currentNode.getNext() == null) {
                    currentNode.setNext(newNode);
                    size++;
                    return;
                }
                if (currentNode.getCurrent().getId() > newNode.getCurrent().getId()) {
                    newNode.setNext(currentNode);
                    previous.setNext(newNode);
                    size++;
                    return;
                }

                previous = previous.getNext();
                currentNode = currentNode.getNext();
            }

        }
    }

}
