package se.terhol.entrytest1;

import java.util.HashSet;

/**
 * @author Tereza Holm
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private int yearlySalary;

    public Employee(String name, HashSet<Integer> salary) {
        this.name = name;
        int yearlySalary = 0;
        for (Integer monthlySalary : salary) {
            yearlySalary = yearlySalary + monthlySalary;
        }
        this.yearlySalary = yearlySalary;
    }

    public int getYearlySalary() {
        return yearlySalary;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        boolean isSame = false;
        if (o instanceof Employee) {
            if (this.getName().equals(((Employee) o).getName()) && this.getYearlySalary() == (((Employee) o).getYearlySalary())) {
                isSame = true;
            }
        }
        return isSame;
    }

    public int hashCode() {
        return this.getName().hashCode() * 31;
    }

    public int compareTo(Employee employee) {
        return employee.getYearlySalary() - this.getYearlySalary();
    }

    public String toString() {
        return String.format("%s: %dCZK/year", this.getName(), this.getYearlySalary());
    }
}
