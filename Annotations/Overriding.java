class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
    }
}
