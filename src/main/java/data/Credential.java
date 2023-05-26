package data;

import lombok.Data;

import java.util.List;

@Data
public class Credential {
    private String email;
    private String password;
    private List<Integer> arrayNumber;
    private List<String> arrayString;
    private Double number;
}
