import java.lang.classfile.ClassFile;
import java.lang.classfile.MethodModel;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Lê o arquivo de bytecode MyClass.class
        ClassFile classFile = ClassFile.read(Paths.get("MyClass.class"));

        // Obtém a lista de métodos declarados
        List<MethodModel> methods = classFile.methods();

        System.out.println("Métodos encontrados na classe:");
        for (MethodModel method : methods) {
            System.out.println(" - " + method.name());
        }
    }
}