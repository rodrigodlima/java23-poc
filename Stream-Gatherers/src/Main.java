import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        var result = Stream.of(1, 1, 2, 2, 2, 3, 1, 1)
                .gather(Gatherers.distinctAdjacent()) // elimina repetições consecutivas
                .toList();

        System.out.println(result);
    }
}
