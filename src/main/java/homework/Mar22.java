package homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mar22 {
    /*
    1. Print all employees who have vehicle that registered before 2018
    2. Print all employees who have vehicle that have registration date in the third quarter (month 7, 8, 9)
    3. Print all employees who own a Mercedes
    4. Print all employees whose vehicle is registered in Hai Chau district (43-C1 and 43-B1)
    5. Use regex to check if employee email is valid or not (user@domain)
    6. Print all employees whose email is invalid
     */


    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = new ArrayList<>(List.of(mapper.readValue(new File("src/test/resources/jsonfiles/employee.json"), Employee[].class)));

        System.out.println("All employees who have vehicle that registered before 2018:");
        for (Employee employee : employeeList) {
            if (Integer.parseInt((String) employee.getVehicle().getRegistrationDate().subSequence(0, 4)) < 2018) {
                System.out.println(employee.getName());
            }
        }

        System.out.println("All employees who have vehicle that have registration date in the third quarter:");
        for (Employee employee : employeeList) {
            if (employee.getVehicle().getRegistrationDate().matches("\\d{4}/0[7-9]/\\d{2}")) {
                System.out.println(employee.getName());
            }
        }

        System.out.println("All employees who own a Mercedes:");
        for (Employee employee : employeeList) {
            if (employee.getVehicle().getMake().equals("Mercedes")) {
                System.out.println(employee.getName());
            }
        }

        System.out.println("All employees whose vehicle is registered in Hai Chau district:");
        for (Employee employee : employeeList) {
            if (employee.getVehicle().getRegistration().matches("43-[BC]1.*")) {
                System.out.println(employee.getName());
            }
        }

        System.out.println("All employees whose email is invalid:");
        for (Employee employee : employeeList) {
            if (!employee.getEmail().matches("^(.+)@([A-Z,a-z]+)\\.([A-Z,a-z]+)")) {
                System.out.println(employee.getName());
            }
        }
    }
}
