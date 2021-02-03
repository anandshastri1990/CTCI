package puzzles;


import linkedlists.SinglyLinkedList;

public class AnimalShelter {
    SinglyLinkedList<Dog> dogs = new SinglyLinkedList<>();
    SinglyLinkedList<Cat> cats = new SinglyLinkedList<>();
    int order = 0;

    public void enqueue(Animal animal) {
        animal.order = order;
        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else {
            cats.add((Cat) animal);
        }
        order++;
    }

    public Animal dequeueAny() {
        if (cats.length() == 0) {
            return dequeueDog();
        } else if (dogs.length() == 0) {
            return dequeueCat();
        }

        if (cats.get(0).order > dogs.get(0).order) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Animal dequeueDog() {
        if (dogs.length() == 0) {
            return null;
        }
        Dog dog = dogs.get(0);
        dogs.remove(0);
        return dog;
    }

    public Animal dequeueCat() {
        if (cats.length() == 0) {
            return null;
        }
        Cat cat = cats.get(0);
        cats.remove(0);
        return cat;
    }
}

class Animal {
    String name;
    int order;

    public Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}