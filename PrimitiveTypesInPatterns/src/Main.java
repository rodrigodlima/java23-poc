public class Main {
    public static void main(String[] args) {
        Object value = 42;

        switch (value) {
            case int i -> System.out.println("It`s an int: " + i);
            case long l -> System.out.println("It`s a long: " + l);
            case double d -> System.out.println("It`s a double: " + d);
            default -> System.out.println("Another type");
        }
    }
}
