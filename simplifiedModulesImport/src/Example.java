import module java.base;

public class Example {
    public static void main(String[] args) {
        Map<Character, List<String>> grouped = Stream.of("apple", "banana", "cherry")
                .collect(Collectors.groupingBy(s -> Character.toUpperCase(s.charAt(0))));
        System.out.println(grouped);
    }
}
