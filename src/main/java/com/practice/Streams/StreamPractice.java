package com.practice.Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StreamPractice {

	static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(
                new Employee("Prerna", "Dutta", 5000.0, List.of("Project 1","Project 2"))
        );

        employees.add(
                new Employee("David", "Copperfield", 6000.0, List.of("Project 1","Project 3"))
        );

        employees.add(
                new Employee("Robert", "Frost", 5500.0, List.of("Project 3","Project 4"))
        );

    }
   
	public static void main(String[] args) {
		
		//forEach is a terminal operation means you cannot do any operation after forEach
		employees.stream().forEach(employee -> System.out.println(employee));
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		//increase salary by 10% 
		List<Employee> employeesWithUpdatedSalary = employees.stream()
				.map(employee -> new Employee(employee.getFirstName(), employee.getLastName(),
						employee.getSalary() * 1.10, employee.getProjects()))
				.collect(Collectors.toList());
		System.out.println("-----------------------------------------------------------------------------------------------");
		employeesWithUpdatedSalary.stream().forEach(employee -> System.out.println(employee));
		
		//increase salary of only those employees whose salary > 5000
		List<Employee> employeesWithUpdatedSalaryAboveBaseSalary = employees.stream()
				.filter(employee -> employee.getSalary() > 5000)
				.map(employee -> new Employee(employee.getFirstName(), employee.getLastName(),
						employee.getSalary() * 1.10, employee.getProjects()))
				.collect(Collectors.toList());
		System.out.println("-----------------------------------------------------------------------------------------------");
		employeesWithUpdatedSalaryAboveBaseSalary.stream().forEach(employee -> System.out.println(employee));
		
		//get first employee whose salary has been increased
		Employee firstEmployee = employees.stream()
				.filter(employee -> employee.getSalary() > 5000)
				.map(employee -> new Employee(employee.getFirstName(), employee.getLastName(),
						employee.getSalary() * 1.10, employee.getProjects()))
				.findFirst()
				.orElse(null);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println(firstEmployee);
		
		//flatMap operation
		String projects = employees.stream()
			.map(employee -> employee.getProjects())
			.flatMap(strings -> strings.stream())
			.distinct()
			.collect(Collectors.joining(","));
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println(projects);
		
		//short circuit operations
		List<Employee> shortCircuit = employees.stream()
			.skip(1)
			.limit(2)
			.collect(Collectors.toList());
		System.out.println("-----------------------------------------------------------------------------------------------");
		shortCircuit.stream().forEach(employee -> System.out.println(employee));
		
		//sort all employees on the basis of first name
		List<Employee> sortedEmployees = employees.stream()
				.sorted((e1,e2)-> e1.getFirstName().compareToIgnoreCase(e2.getFirstName()))
				.collect(Collectors.toList());
		System.out.println("-----------------------------------------------------------------------------------------------");
		sortedEmployees.stream().forEach(employee -> System.out.println(employee));
		
		//get employee max salary
		Employee maxSalariedEmployee = employees.stream()
				.max(Comparator.comparing(Employee::getSalary))
				.orElseThrow(NoSuchElementException::new);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println(maxSalariedEmployee);
		
		//sum of all salaries
		Double totalSalary = employees.stream()
				.map(employee -> employee.getSalary())
				.reduce(0.0, Double::sum);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println(totalSalary);
	}
}
