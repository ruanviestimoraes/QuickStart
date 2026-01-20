package studyMyself.oop;

class Organism {
    boolean isAlive;

    Organism() {
        isAlive = true;

    }

}

class Animal extends Organism {

    void eat() {
        System.out.println(this.getClass().getSimpleName() + " is eating...  ");

    }
}

class Dog extends Animal {

    int lives = 1;

    void speak() {
        System.out.println("Dog barks... ");
    }

}

class Cat extends Animal {

    int lives = 7;

    void speak() {
        System.out.println("Cat meows... ");
    }

}

public class inherantance {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.eat();
        System.out.println(cat.lives);

    }

}
