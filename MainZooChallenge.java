
abstract class Animal {
    //fields
    private String name;
    private int age;

    //abstract methods
    public abstract void speak();

    public abstract void move();

    
    //constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    //Accessors
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    //Mutators
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}

//interfaces
interface Flyable {
    void fly();
    boolean canFly();
}

interface Runnable {
    void run();
    boolean canRun();
}

interface Swimmable {
    void swim();
    boolean canSwim();
}

//subclass Bird
class Bird extends Animal implements Flyable, Runnable, Swimmable {
    //constructor
    public Bird(String name, int age) {
        super(name, age);
    }

    //overriding Animal methods
    @Override
    public void speak() {
        System.out.println("Chirp! I'm a cool bird 🐦 named " + getName() + " and I'm " + getAge() + " y/o" );
    }

    @Override
    public void move() {
        System.out.println(getName() + " moves on 2 legs");
    }

    //interface - Flyable
    @Override
    public void fly() {
        System.out.println(getName() + " is flying high!");
    }

    @Override
    public boolean canFly() {
        return true;
    }

    //interface - Runnable
    @Override
    public void run() {
        System.out.println(getName() + " can't run");
    }

    @Override
    public boolean canRun() {
        return false;
    }

    //interface - Swimmable
    @Override
    public void swim() {
        System.out.println(getName() + " can't swim");
    }

    @Override
    public boolean canSwim() {
        return true;
    }
}

//subclass Cat
class Cat extends Animal implements Flyable, Runnable, Swimmable{
    //constructor
    public Cat(String name, int age) {
        super(name, age);
    }

    //overriding abstract methods
    @Override
    public void speak() {
        System.out.println("Meow! I'm a cool cat 😺 named" + getName() + " and " + getAge() + " y/o");
    }

    @Override
    public void move() {
        System.out.println(getName() + " moves on 4 legs");
    }

    //interface - Flyable
    @Override
    public void fly() {
        System.out.println(getName() + " can't fly!");
    }

    @Override
    public boolean canFly() {
        return false;
    }

    //interface - Runnable
    @Override
    public void run() {
        System.out.println(getName() + " is running");
    }

    public boolean canRun() {
        return true;
    }

    //interface - Swimmable
    @Override
    public void swim() {
        System.out.println(getName() + " can swim");
    }

    @Override
    public boolean canSwim() {
        return true;
    }
}

//subclass Dog
class Dog extends Animal implements Flyable, Runnable, Swimmable {
    //constructor
    public Dog(String name, int age) {
        super(name, age);
    }

    //overriding abstract methods
    @Override
    public void speak() {
        System.out.println("Woof! I'm a cool dog 🐶 named " + getName() + " and" + getAge() + " y/0");
    }

    @Override
    public void move() {
        System.out.println(getName() + " moves on 4 legs");
    }
    //interface - Flyable
    @Override
    public void fly() {
        System.out.println(getName() + " can't fly!");
    }

    @Override
    public boolean canFly() {
        return false;
    }

    //interface - Runnable
    @Override
    public void run() {
        System.out.println(getName() + " is running");
    }

    public boolean canRun() {
        return true;
    }

    //interface - Swimmable
    @Override
    public void swim() {
        System.out.println(getName() + " can swim");
    }

    @Override
    public boolean canSwim() {
        return true;
    }

}

//driver class
public class MainZooChallenge {

    public static void main(String[] args) {
        //Polymorphic declarations
        Animal a1 = new Bird("Daffy", 4);
        Animal a2 = new Cat("Tom", 6);
        Animal a3 = new Dog("Bob", 9);

        //store in Animal array
        Animal zoo[] = {a1, a2, a3};

        //Ability counters
        int flyCount = 0;
        int runCount = 0;
        int swimCount = 0;

        //Looping and printing
        for(Animal animal : zoo) {
            System.out.println("\n--- Animal Report ---");

            animal.speak(); //Dynamic dispatch
            animal.move(); //Dynamic dispatch

            //check Runtime
            if(animal instanceof Flyable) {
                ((Flyable)animal).canFly();
                ((Flyable)animal).fly();
                flyCount++;
            }

            if(animal instanceof Runnable) {
                ((Runnable)animal).canRun();
                ((Runnable)animal).run();
                runCount++;
            }

            if(animal instanceof Swimmable) {
                ((Swimmable)animal).canSwim();
                ((Swimmable)animal).swim();
                swimCount++;
            }
        }

        //Ability summary
        System.out.println("\n=== Ability Summary ====");
        System.out.println("Flyable Animals: " + flyCount);
        System.out.println("Runnable Animals: " + runCount);
        System.out.println("Swimmable Animals: " + swimCount);
    }
}