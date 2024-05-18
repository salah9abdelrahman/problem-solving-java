package data_structure.hashtable;

import data_structure.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapJdk {
    public static void main(String[] args) {
        Employee salah = new Employee("Salah", "Abdo", 4);
        Employee hussein = new Employee("Hussein", "Abdelrahman", 1);
        Employee lobna = new Employee("Lobna", "said", 3);
        Employee nour = new Employee("Nour", "Rahim", 2);
        Employee zain = new Employee("zain", "mhmd", 2);
        Employee oudi = new Employee("Oudi", "Amr", 5);

        Map<String, Employee> map = new HashMap<>();
        map.put(salah.getLastName(), salah);
        map.put(hussein.getLastName(), hussein);
        map.put(lobna.getLastName(), lobna);
        map.put(oudi.getLastName(), oudi);

        // override existing element if exists
        map.put(salah.getLastName(), nour);

        // to not override
        map.putIfAbsent(lobna.getLastName(), zain);

        // get: return null if not exist
        System.out.println(map.get("bla"));

        // specify default element if null
        System.out.println(map.getOrDefault("bla", salah));
        System.out.println(map.getOrDefault(hussein.getLastName(), salah));



        map.forEach((k, v) -> System.out.println(v));


    }
}
