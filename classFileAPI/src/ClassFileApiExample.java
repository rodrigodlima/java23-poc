import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClassFileApiExample {
    public static void main(String[] args) throws IOException, URISyntaxException {

        var url = Animal.class.getResource("Animal.class");
        if (url == null) {
            throw new IllegalStateException("Unable to find Animal.class");
        }


        Path classFilePath = Path.of(url.toURI());


        byte[] classBytes = Files.readAllBytes(classFilePath);


        ClassModel classModel = ClassFile.of().parse(classBytes);


        classModel.methods().forEach(m ->
                System.out.println("Método: " + m.methodName().stringValue())
        );
    }
}
