import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleJava21 {
    public static void main(String[] args) {
        Map<Character, List<String>> grouped = Stream.of("apple", "banana", "cherry")
            .collect(Collectors.groupingBy(s -> Character.toUpperCase(s.charAt(0))));
        System.out.println(grouped);
    }
}
