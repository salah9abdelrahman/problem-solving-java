package data_structure.hashtable.chainedhashtable;

import data_structure.Employee;
import data_structure.hashtable.StoredEmployee;

import java.util.LinkedList;
import java.util.ListIterator;

/*
Handling collisions by chaining
 */
public class ChainedHashtable {
    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtable() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<>();
        }
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> listIterator = hashtable[hashedKey].listIterator();
        StoredEmployee storedEmployee;
        while (listIterator.hasNext()) {
            storedEmployee = listIterator.next();
            if (storedEmployee.getKey().equals(key)) {
                return storedEmployee.getEmployee();
            }
        }
        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> listIterator = hashtable[hashedKey].listIterator();
        StoredEmployee storedEmployee = null;
        int index = 0;
        while (listIterator.hasNext()) {
            storedEmployee = listIterator.next();
            if (storedEmployee.getKey().equals(key)) {
                break;
            } else {
                index++;
            }
        }

        if (storedEmployee == null || !storedEmployee.getKey().equals(key)) {
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return storedEmployee.getEmployee();
        }
    }

    private int hashKey(String key) {
        return Math.abs(key.hashCode() % hashtable.length);
//        return key.length() % hashtable.length;
    }

    public void printHashtable() {
        System.out.println("*************");
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("empty");
            } else {
                ListIterator<StoredEmployee> listIterator = hashtable[i].listIterator();
                while (listIterator.hasNext()) {
                    System.out.print(listIterator.next().getEmployee() + " <-> ");
                }
                System.out.print("null");
                System.out.println();
            }
        }
        System.out.println("*************");
    }
}
