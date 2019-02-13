package se.terhol.entrytest1;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author Tereza Holm
 */
public class Salary {
    private static int averageYearlySalary(HashSet<Employee> employees) {
        int allSalaries = 0;
        int numberOfEmployees = 0;
        int averageSalary;
        for (Employee employee : employees) {
            allSalaries = allSalaries + employee.getYearlySalary();
            numberOfEmployees++;
        }
        averageSalary = allSalaries / numberOfEmployees;
        return averageSalary;
    }

    public static TreeSet<Employee> getEmployeesWithSalaryAboveAverage(HashSet<Employee> employees) {
        int averageSalary = averageYearlySalary(employees);
        TreeSet<Employee> employeesWithGoodSalary = new TreeSet<>();
        for (Employee employee : employees) {
            if (employee.getYearlySalary() > averageSalary) {
                employeesWithGoodSalary.add(employee);
            }
        }
        return employeesWithGoodSalary;
    }
}
