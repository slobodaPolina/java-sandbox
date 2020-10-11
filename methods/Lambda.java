package methods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambda { }

class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;
    public Animal(String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }
    public boolean canHop() { return canHop; }
    public boolean canSwim() { return canSwim; }
    public String toString() { return species; }
}
interface CheckTrait {
    boolean test(Animal a);
}
class CheckIfHopper implements CheckTrait {
    public boolean test(Animal a) {
        return a.canHop();
    }
}
class CheckIfSwimmer implements CheckTrait {
    public boolean test(Animal a) {
        return a.canSwim();
    }
}
class TraditionalSearch {
    {
        List<Animal> animals = new ArrayList<Animal>(); // list of animals
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        print(animals, new CheckIfHopper());
        print(animals, new CheckIfSwimmer());
    }
    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal))
                System.out.print(animal + " ");
        }
    }
}

// fuuuh - a lot of work. Lets make it easier (No additional classes and interfaces):
class ImprovedSearch {
    {
        List<Animal> animals = new ArrayList<Animal>(); // list of animals
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        print(animals, a -> a.canSwim());
        print(animals, a -> a.canHop());
        // p.s: these variants are also possible
        print(animals, (Animal a) -> { return a.canHop(); });
        print(animals, (a) -> { return a.canHop(); }); // if we omit input type(s), Java will use the "print" definition to understand "a" has to be an Animal
    }
    private static void print(List<Animal> animals, Predicate<Animal> checker) {
        // actually here we still can write "CheckTrait checker" instead of Predicate <Animal> checker and it will work because it is just the same..
        /*
            public interface Predicate<T> {
                boolean test(T t);
            }
         */
        for (Animal animal : animals) {
            if (checker.test(animal))
                System.out.print(animal + " ");
        }
    }
    // P.S: ArrayList has a removeIf(Predicate<T>) method, which allows u to specify a condition for elems to be removed
}