package data_structure.hashtable.simplehashtable;

import data_structure.Employee;
import data_structure.hashtable.StoredEmployee;

/*
Handling collisions by Open Addressing (Linear probing as  probe sequence)
 */

public class SimpleHashtable {
    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        this.hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        //linear probing
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            // set first prob value
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while ((occupied(hashedKey)) && (hashedKey != stopIndex)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }
        if (occupied(hashedKey)) {
            System.out.println("Sorry, there's an employee at position: " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        } else {
            return hashtable[hashedKey].getEmployee();
        }
    }


    private boolean occupied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if ((occupied(hashedKey)) && (hashtable[hashedKey].getKey().equals(key))) {
            return hashedKey;
        }
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while ((hashedKey != stopIndex)) {
            if (hashtable[hashedKey] == null || !hashtable[hashedKey].getKey().equals(key)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
                continue;
            }
            return hashedKey;
        }
        return -1;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        } else {
            Employee employee = hashtable[hashedKey].getEmployee();
            hashtable[hashedKey] = null;
            return employee;
        }
    }

    public void printHashtable() {
        System.out.println("**********");
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                System.out.println(hashtable[i].getEmployee());
            } else {
                System.out.println("empty ");
            }
        }
        System.out.println("**********");
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }
}
