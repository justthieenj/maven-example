package homework;

import data.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Mar01 {
    public static void main(String[] args) throws IOException {
        // 1. Read file employee.json from the resources folder
        List<Employee> employeeList = readEmployeeJsonFile("src/test/resources/jsonfiles/employee.json");

        System.out.println("List of Employee objects that have a salary greater than 10000:");
        for (Employee employee : employeeListNo4(employeeList)) {
            System.out.print("Name: " + employee.getName() + "\t\t");
            System.out.println("Salary: " + employee.getSalary());
        }
        System.out.println();

        System.out.println("List of Employee objects that have a salary greater than 10000 and live in San Francisco:");
        for (Employee employee : employeeListNo5(employeeList)) {
            System.out.print("Name: " + employee.getName() + "\t\t");
            System.out.print("Salary: " + employee.getSalary() + "\t\t");
            System.out.println("City: " + employee.getCity());
        }
        System.out.println();

        System.out.println("List of Employee objects that have a salary less than 10000 and live in Boston or New York:");
        for (Employee employee : employeeListNo6(employeeList)) {
            System.out.print("Name: " + employee.getName() + "\t\t");
            System.out.print("Salary: " + employee.getSalary() + "\t\t");
            System.out.println("City: " + employee.getCity());
        }
        System.out.println();

        System.out.println("List of Employee objects that live in Boston or New York and are older than 30:");
        for (Employee employee : employeeListNo7(employeeList)) {
            System.out.print("Name: " + employee.getName() + "\t\t");
            System.out.print("City: " + employee.getCity() + "\t\t");
            System.out.println("Age: " + employee.getAge());
        }
        System.out.println();

        // 8. Sort the list of employees by salary in descending order
        System.out.println("List of Employee objects sorted by salary in descending order:");
        employeeList.sort(Comparator.comparing(Employee::getSalary).reversed());
        for (Employee employee : employeeList) {
            System.out.print("Name: " + employee.getName() + "\t\t");
            System.out.println("Salary: " + employee.getSalary());
        }
        System.out.println();

        // 9. return the list of employees that have job title "Business Analyst"
        System.out.println("List of Employee objects that have job title \"Business Analyst\":");
        List<Employee> businessAnalyst = employeeList.stream()
                .filter(employee -> employee.getJobTitle().equals("Business Analyst"))
                .toList();
        for (Employee employee : businessAnalyst) {
            System.out.print("Name: " + employee.getName() + "\t\t");
            System.out.println("Job title: " + employee.getJobTitle());
        }
        System.out.println();
    }

    // 3. Create a method that returns a list of Employee objects from the json file
    public static List<Employee> readEmployeeJsonFile(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return new ArrayList<>(List.of(mapper.readValue(new File(path), Employee[].class)));
    }

    // 4. Create a method that returns a list of Employee objects that have a salary greater than 10000
    public static List<Employee> employeeListNo4(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary() > 10000)
                .toList();
    }

    // 5. Create a method that returns a list of Employee objects that have a salary greater than 10000 and live in San Francisco
    public static List<Employee> employeeListNo5(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary() > 10000 && employee.getCity().equals("San Francisco"))
                .toList();
    }

    // 6. Create a method that returns a list of Employee objects that have a salary less than 10000 and live in Boston or New York
    public static List<Employee> employeeListNo6(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary() < 10000 && (employee.getCity().equals("Boston") || employee.getCity().equals("New York")))
                .toList();
    }

    // 7. Create a method that returns a list of Employee objects that live in Boston or New York and are older than 30
    public static List<Employee> employeeListNo7(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(employee -> (employee.getCity().equals("Boston") || employee.getCity().equals("New York")) && employee.getAge() > 30)
                .toList();
    }
}
