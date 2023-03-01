import com.fasterxml.jackson.databind.ObjectMapper;
import data.Dummy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class DummyTest {
    @Test
    public void TestReadFile() {
        Assertions.assertEquals("A", "A");
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Dummy value = mapper.readValue(new File("src/test/resources/jsonfiles/dummy.json"), Dummy.class);
        System.out.println(value.getImages());
        String b = """
                line 1
                line 2
                line 3
                """;
        System.out.println(b);
    }
}
