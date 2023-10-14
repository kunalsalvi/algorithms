package org.imuniverse;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Playground {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Kunal", 41));
        employees.add(new Employee("Manasi", 40));
        employees.add(new Employee("Riya", 11));
        employees.add(new Employee("Shripat", 68));
        employees.add(new Employee("Veena", 61));

        employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .ifPresent(employee -> System.out.println(employee.getName()));

        List<Integer> numbers = List.of(1, 2, 3, 5, 5);

        Map<Integer, Long> result = numbers.stream()
                .filter(val -> val > 3)
                .collect(groupingBy(i -> i, counting()));

        System.out.println(1 == result.size());

        result = numbers.stream()
                .collect(groupingBy(i -> i, filtering(val -> val > 3, counting())));

        System.out.println(4 == result.size());
        System.out.println();

        Map<Integer, Set<Employee>> peopleAbove50ByAge = employees.stream()
                .collect(groupingBy(Employee::getAge, filtering(e -> e.getAge() > 50, toSet())));
        peopleAbove50ByAge.forEach((k,v) -> v.forEach(employee -> System.out.println(employee.getName())));

    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}