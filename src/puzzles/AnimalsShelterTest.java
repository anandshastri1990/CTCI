package puzzles;


import org.junit.Before;
import org.junit.Test;

public class AnimalsShelterTest {

    AnimalShelter animalShelter;

    @Before
    public void setup() {
        animalShelter = new AnimalShelter();
    }

    @Test
    public void enqueue() {
        animalShelter.enqueue(new Dog("Tommy"));
        animalShelter.enqueue(new Cat("lady"));
    }

    @Test
    public void dequeueDog() {
        animalShelter.enqueue(new Dog("Tommy1"));
        animalShelter.enqueue(new Cat("lady1"));
        animalShelter.enqueue(new Dog("Tommy2"));
        animalShelter.enqueue(new Cat("lady2"));
        animalShelter.enqueue(new Dog("Tommy3"));

        assert (animalShelter.dequeueDog().name.equals("Tommy1"));
        assert (animalShelter.dequeueDog().name.equals("Tommy2"));
        assert (animalShelter.dequeueDog().name.equals("Tommy3"));
    }

    @Test
    public void dequeueCat() {
        animalShelter.enqueue(new Dog("Tommy1"));
        animalShelter.enqueue(new Cat("lady1"));
        animalShelter.enqueue(new Dog("Tommy2"));
        animalShelter.enqueue(new Cat("lady2"));
        animalShelter.enqueue(new Dog("Tommy3"));

        assert (animalShelter.dequeueCat().name.equals("lady1"));
        assert (animalShelter.dequeueCat().name.equals("lady2"));
    }

    @Test
    public void dequeueAny() {
        animalShelter.enqueue(new Dog("Tommy1"));
        animalShelter.enqueue(new Cat("lady1"));
        animalShelter.enqueue(new Dog("Tommy2"));
        animalShelter.enqueue(new Cat("lady2"));
        animalShelter.enqueue(new Dog("Tommy3"));

        assert (animalShelter.dequeueAny().name.equals("Tommy1"));
        assert (animalShelter.dequeueAny().name.equals("lady1"));
        assert (animalShelter.dequeueAny().name.equals("Tommy2"));
        assert (animalShelter.dequeueAny().name.equals("lady2"));
        assert (animalShelter.dequeueAny().name.equals("Tommy3"));
        assert (animalShelter.dequeueAny() == null);
    }
}