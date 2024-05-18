package data_structure.list.arrayList;

import data_structure.Employee;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

//        employeeList.forEach(System.out::println);
//        employeeList.set(1, new Employee("salah", "abdelrahman", 433));
        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22)));
        System.out.println(employeeList.indexOf(new Employee("Mary", "Smith", 22)));
//        System.out.println(employeeList.get(1));


    }
}
