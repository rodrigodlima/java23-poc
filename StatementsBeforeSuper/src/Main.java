class Animal {
    Animal(String name) {
        System.out.println("Animal: " + name);
    }
}

class Dog extends Animal {
    Dog(String name) {
        System.out.println("Preparing...");
        super(name); // agora permitido após uma instrução
    }
}

public class Main {
    public static void main(String[] args) {
        new Dog("Rex");
    }
}
