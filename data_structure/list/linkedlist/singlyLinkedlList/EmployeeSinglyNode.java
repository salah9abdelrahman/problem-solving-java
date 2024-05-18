package data_structure.list.linkedlist.singlyLinkedlList;

import data_structure.Employee;

public class EmployeeSinglyNode {
    private Employee current;
    private EmployeeSinglyNode next;

    public EmployeeSinglyNode(Employee employee) {
        this.current = employee;
    }

    public Employee getCurrent() {
        return current;
    }

    public void setCurrent(Employee current) {
        this.current = current;
    }

    public EmployeeSinglyNode getNext() {
        return next;
    }

    public void setNext(EmployeeSinglyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return current.toString();
    }
}
