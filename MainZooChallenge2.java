//package declaration
import java.util.ArrayList;
import java.util.List;

//super class : Animal
abstract class Animal {
    //fields
    private String name;
    private int age;
    private String healthStatus; //Healthy, Injured, Recovering
    
    //constructor
    public Animal(String name, int age, String healthStatus) {
        this.name = name;
        this.age = age;
        this.healthStatus = healthStatus;
    }

    //Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    //Setters
    public void setAge(int age) {
        this.age = age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    //abstract methods
    public abstract void speak();
    public abstract void move();
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

//subclass : Bird
class Bird extends Animal implements Flyable, Runnable, Swimmable {
    //constructor
    public Bird(String name, int age, String healthStatus) {
        super(name, age, healthStatus);
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

//subclass : Cat
class Cat extends Animal implements Flyable, Runnable, Swimmable{
    //constructor
    public Cat(String name, int age, String healthStatus) {
        super(name, age, healthStatus);
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

//subclass : Dog
class Dog extends Animal implements Flyable, Runnable, Swimmable {
    //constructor
    public Dog(String name, int age, String healthStatus) {
        super(name, age, healthStatus);
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

//zoo management class : RescueCentre
class RescueCentre {
    //create Animal Rescue Centre
    public List<Animal> animals = new ArrayList<>();

    //method to Register animals to be Rescued
    public void registerAnimal(Animal a) {
        animals.add(a);
        System.out.println("Registered: " + a.getName() + "(" + getClass().getSimpleName() + ")");
    }

    //print animals
    public void printAnimals() {
        for(Animal a : animals) {
            System.out.println("\nName: " + a.getName());
            System.out.println("Type: " + a.getClass().getSimpleName());
            System.out.println("Health: " + a.getHealthStatus());
            a.speak();
            a.move();

            //check Runtime
            if(a instanceof Flyable f) {
                f.fly();
                System.out.println("Can Run: " + (f.canFly() ? "yes" : "no"));
            }

            if(a instanceof Runnable r) {
                r.run();
                System.out.println("Can Run: " +(r.canRun() ? "yes" : "no"));
            }

            if(a instanceof Swimmable s) {
                s.swim();
                System.out.println("Can Run: " +(s.canSwim() ? "yes" : "no"));
            }
        }
    }

    //Ability summary
    public void abilitySummary() {
        //count animals on their ability and rescue need
        int flyCount = 0;
        int runCount = 0;
        int swimCount = 0;
        int Injured = 0;

        //Looping and printing
        for(Animal a : animals) {
            //count animals for the need of Rescue
            if(a.getHealthStatus().equalsIgnoreCase("Injured")) {
                Injured++;
            }

            //count animals for their ability
            if(a instanceof Flyable && ((Flyable)a).canFly()) {
                flyCount++;
            }

            if(a instanceof Runnable && ((Runnable)a).canRun()) {
                runCount++;
            }

            if(a instanceof Swimmable && ((Swimmable)a).canSwim()) {
                swimCount++;
            }
        }

        //Ability Summary print
        System.out.println("\n==== Rescue Zoo Ability Summary ====");
        System.out.println("Flyable Animals: " + flyCount);
        System.out.println("Runnable Animals: " + runCount);
        System.out.println("Swimmable Animals: " + swimCount);
        System.out.println("Injured Animals: " + Injured);
    }
}

//driver class
public class MainZooChallenge2 {
    
    public static void main(String[] args) {
        //create RescueCentre class reference
        RescueCentre centre = new RescueCentre();
        
        centre.registerAnimal(new Bird("Daffy", 2, "Injured"));
        centre.registerAnimal(new Cat("Whiskers", 4, "Healthy"));
        centre.registerAnimal(new Dog("Bruno", 5, "Recovering"));

        //print all animals
        centre.printAnimals();

        //print ability summary
        centre.abilitySummary();
    }
}
