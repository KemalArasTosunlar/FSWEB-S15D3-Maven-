package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null && !seen.add(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        Map<Integer, Employee> uniqueEmployees = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                if (seen.contains(employee)) {
                    uniqueEmployees.put(employee.getId(), employee);
                } else {
                    seen.add(employee);
                }
            }
        }
        return uniqueEmployees;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> result = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null && !seen.contains(employee)) {
                result.add(employee);
                seen.add(employee);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example of using these methods
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));

        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> noDuplicates = removeDuplicates(employees);

        // Printing the results for verification
        System.out.println("Duplicates: " + duplicates.size());
        System.out.println("Uniques: " + uniques.size());
        System.out.println("No Duplicates: " + noDuplicates.size());
    }
}
