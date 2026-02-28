package com;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    //1
    public double averageSalary() {
        double avgSal = EmployeeRepository.getEmployees().stream().map(e -> e.getSalary())
                .collect(Collectors.averagingDouble(e -> e));
        return avgSal;
    }
    //2
    public void employeeWithMaxSalary(){
        EmployeeRepository.getEmployees().stream()
                .filter(e -> e.getDepartment() != null)
                .collect(Collectors.groupingBy(e -> e.getDepartment().getDepartmentName()))
                .forEach((dept, employees) -> {

                    Employee maxSal = employees.stream()
                            .max(Comparator.comparingDouble(Employee::getSalary))
                            .get();

                    System.out.println(dept + " : " + maxSal.getFirstName());
                });
    }


    //3
    public Map<Department,Double> totalSalPerDept(){
        return EmployeeRepository.getEmployees().stream().filter(e->e.getDepartment()!=null)
                .collect(Collectors.groupingBy(e->e.getDepartment(),Collectors
                        .mapping(e->e.getSalary(),Collectors.reducing(0.0, (a, b) -> a + b))));
    }

   //4
    public void displayEmployeeNameAndSalary() {
        EmployeeRepository.getEmployees().stream()
                .forEach(e ->
                        System.out.println(
                                e.getFirstName() + " "
                                        + e.getLastName()
                                        + " : " + e.getSalary())
                );
    }
   //5
    public void sortBySalaryDescending(){
        EmployeeRepository.getEmployees().stream().sorted((e1,e2)->Double.compare(e2.getSalary(),e1.getSalary()))
                .forEach(e->System.out.println(e.getSalary()));
    }
}


