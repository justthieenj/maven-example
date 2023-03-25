import java.util.Arrays;

public class RegexTest {
    private static final String TEXT = """
            The cat fat ran down the street.
            It was searching for a mouse to eat.
            """;

    public static void main(String[] args) {
        String a = "a,1d,2b,3t,9s";
        var arr = a.split(",\\d");
        "cat".matches("\\w{3}"); // true
        TEXT.matches("cat"); // false
        Arrays.stream(arr).forEach(System.out::println);
    }
}
