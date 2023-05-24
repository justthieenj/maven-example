import com.fasterxml.jackson.databind.ObjectMapper;
import data.Credential;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TestReadCredential {
    @Test
    public void testReadCredential() {
        var listCredential = readJsonFile();
        listCredential.forEach(System.out::println);

        // get by email
        var email = "ngoc.vo3@gmail.com";
        Credential user3 = listCredential.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("get by email: " + email);
        System.out.printf("%s - %s", user3.getEmail(), user3.getPassword());
    }

    public static List<Credential> readJsonFile() {
        try {
            var path = "src/test/resources/credential.json";
            ObjectMapper mapper = new ObjectMapper();
            return new ArrayList<>(List.of(mapper.readValue(new File(path), Credential[].class)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
