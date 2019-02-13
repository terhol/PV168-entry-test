package se.terhol.entrytest1;

import java.io.IOException;
import java.net.URL;
import java.util.TreeSet;

/**
 * @author Tereza Holm
 */
public class Main {
    public static void main(String[] args) {
        try {
            TreeSet<Employee> listOfEmployeesWithGoodSalary =
                    Salary.getEmployeesWithSalaryAboveAverage(FileLoading.loadFile(new URL("https://acrab.ics.muni.cz/~makub/soubor.txt").openStream()));
            for (Employee employee : listOfEmployeesWithGoodSalary) {
                System.out.println(employee);
            }
        } catch (IOException e) {
            System.err.println("Incorrect URL.");
        }
    }
}
