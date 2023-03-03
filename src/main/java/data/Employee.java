package data;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private int age;
    private String city;
    private String jobTitle;
    private Double salary;
}
