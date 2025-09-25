class Animal {
    Animal(String name) {
        System.out.println("Animal: " + name);
    }
}

class Dog extends Animal {
    Dog(String name) {
        System.out.println("Preparing...");
        super(name); // now it's permitted after an instruction
    }
}

public class Main {
    public static void main(String[] args) {
        new Dog("Rex");
    }
}
