package data_structure.hashtable;

import data_structure.Employee;
import data_structure.hashtable.chainedhashtable.ChainedHashtable;
import data_structure.hashtable.simplehashtable.SimpleHashtable;

public class HashtableMain {
    public static void main(String[] args) {
        Employee salah = new Employee("Salah", "Abdo", 4);
        Employee hussein = new Employee("Hussein", "Abdelrahman", 1);
        Employee lobna = new Employee("Lobna", "said", 3);
        Employee nour = new Employee("Nour", "Rahim", 2);
        Employee zain = new Employee("zain", "mhmd", 2);
        Employee oudi = new Employee("Oudi", "Amr", 5);

//        SimpleHashtable hashtable = new SimpleHashtable();
        ChainedHashtable hashtable = new ChainedHashtable();
        hashtable.put(salah.getLastName(), salah);
        hashtable.put(hussein.getLastName(), hussein);
        hashtable.put(lobna.getLastName(), lobna);
        hashtable.put(oudi.getLastName(), oudi);
        hashtable.put(zain.getLastName(), zain);
        hashtable.printHashtable();

        System.out.println(hashtable.get(salah.getLastName()));
        System.out.println(hashtable.get(lobna.getLastName()));
        System.out.println(hashtable.remove(lobna.getLastName()));

        hashtable.printHashtable();

        System.out.println( hashtable.get(zain.getLastName()));

    }
}


