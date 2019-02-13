package se.terhol.entrytest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;


/**
 * @author Tereza Holm
 */
public class FileLoading {
    public static HashSet<Employee> loadFile(InputStream is) {
        HashSet<Employee> allEmployees = new HashSet<>();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line = in.readLine();

            while (line  != null) {
                Employee employee = makeEmployee(line);
                allEmployees.add(employee);
                line = in.readLine();
            }

        } catch (IOException e) {
            System.err.println("Problem with reading file.");
        }

        return allEmployees;
    }

    private static Employee makeEmployee(String line) {
        int endOfName = line.indexOf(";");
        String name = line.substring(0, endOfName);
        HashSet<Integer> salary = makeEmployeeSalary(line);

        return new Employee(name, salary);
    }

    private static HashSet<Integer> makeEmployeeSalary(String line){
        HashSet<Integer> salary = new HashSet<>();
        int beginningOfNumber = line.lastIndexOf(";") + 1;
        int endOfNumber = line.indexOf(",");

        for (int i = 0; i < 11; i++) {
            int monthlySalary = Integer.parseInt(line.substring(beginningOfNumber, endOfNumber));
            salary.add(monthlySalary);
            beginningOfNumber = endOfNumber + 1;
            endOfNumber = line.indexOf(",", beginningOfNumber);
        }
        int lastSalary = Integer.parseInt(line.substring(line.lastIndexOf(",") + 1));
        salary.add(lastSalary);
        return salary;

    }
}
