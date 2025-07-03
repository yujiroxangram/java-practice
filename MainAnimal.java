//base class
class Animal {
    //fields
    private String name;
    private int age;

    //default method
    public void speak() {
        System.out.println("This animal makes a sound.");
    }

    //constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

//sub class Cat
class Cat extends Animal {
    //constructor
    public Cat(String name, int age) {
        super(name, age); //calling AnimaL constructor
    }

    //overriding Animal method
    @Override
    public void speak() {
        System.out.println("Meow! I'm a  cool cat 😺 named " + getName() );
    }
}

//sub class Dog
class Dog extends Animal {
    //fields
    private String breed;

    //constructor
    public Dog(String name, int age, String breed) {
        super(name, age); //calling Animal constructor
        this.breed = breed;
    }

    //Getters
    public String getBreed() {
        return breed;
    }

    //overriding Animal method
    @Override
    public void speak() {
        System.out.println("Woof! I'm "  + breed + " dog 🐶 named " + getName() );
    }
}

//driver class
public class MainAnimal {
    
    public static void main(String[] args) {
        //creating Animal objects
        Animal zoo[] = {
            new Cat("Whiskers", 3),
            new Dog("Rocky", 5, "Labrador"),
            new Dog("Max", 8, "German Shepherd")
        };

        //Looping and printing
        for(Animal a : zoo) {
            a.speak();

            //check Runtime
            if(a instanceof Dog) {
                Dog d = (Dog) a;
                System.out.println("Breed: " + d.getBreed());
            }
        }
    }
}