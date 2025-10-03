import java.util.stream.*;
import static java.util.stream.Gatherers.*;

public class Main {
    public static void main(String[] args) {
        var batched = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .gather(windowFixed(3))  // create "windows" of 3
                .toList();

        System.out.println(batched);
    }
}
