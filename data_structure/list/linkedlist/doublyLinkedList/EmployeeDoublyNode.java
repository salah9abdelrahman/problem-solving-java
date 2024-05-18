package data_structure.list.linkedlist.doublyLinkedList;

import data_structure.Employee;

public class EmployeeDoublyNode {
    private Employee current;
    private EmployeeDoublyNode next;
    private EmployeeDoublyNode previous;

    public EmployeeDoublyNode(Employee employee) {
        this.current = employee;
    }

    public Employee getCurrent() {
        return current;
    }

    public void setCurrent(Employee current) {
        this.current = current;
    }

    public EmployeeDoublyNode getNext() {
        return next;
    }

    public void setNext(EmployeeDoublyNode next) {
        this.next = next;
    }

    public EmployeeDoublyNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeDoublyNode previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return current.toString();
    }
}
