package data;

import lombok.Data;

import java.util.List;

@Data
public class Dummy {
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private List<String> images;
}
