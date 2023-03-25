package homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Mar22 {
    /*
    1. Print all employees who have vehicle that registered before 2018
    2. Print all employees who have vehicle that have registration date in the third quarter (month 7, 8, 9)
    3. Print all employees who own a Mercedes
    4. Print all employees whose vehicle is registered in Hai Chau district (43-C1 and 43-B1)
    5. Use regex to check if employee email is valid or not (user@domain)
    6. Print all employees whose email is invalid
     */

    private static String getSubString(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = new ArrayList<>(List.of(mapper.readValue(new File("src/test/resources/jsonfiles/employee.json"), Employee[].class)));

        System.out.println("All employees who have vehicle that registered before 2018:");
        var newList = employeeList
                .stream()
                .filter(employee -> Integer.parseInt(getSubString(employee.getVehicle().getRegistrationDate(), "^\\d{4}")) < 2018)
                .toList();

//        for (Employee employee : employeeList) {
//            if (Integer.parseInt((String) employee.getVehicle().getRegistrationDate().subSequence(0, 4)) < 2018) {
//                System.out.println(employee.getName());
//            }
//        }

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
            if (!employee.getEmail().matches("^(.+)@(\\w|\\d)+\\.(\\w+)")) {
                System.out.println(employee.getName());
            }
        }
    }
}
