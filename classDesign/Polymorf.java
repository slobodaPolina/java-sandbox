package classDesign;

public class Polymorf {
    // obj can be a type of own class, a superclass or an interface (own one or an interface of superclass..)
}

class PrimateClass {
    public boolean hasHair() {
        return true;
    }
}
interface HasTail {
    public abstract boolean isTailStriped();
}

class Lemur extends PrimateClass implements HasTail {
    public boolean isTailStriped() {
        return false;
    }
    public int age = 10;
    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        HasTail hasTail = new Lemur(); // it is smth of type implements an interface
        hasTail = lemur; // not a problem - the SAME object can be referenced (the new Lemur() object does not change when we create a ref of some type)
        System.out.println(hasTail.isTailStriped());

        PrimateClass primate = new Lemur(); // ref of type of superclass
        System.out.println(primate.age); // here is a problem. Age was created in Lemur class and does not exist in the parent class PrimateClass
        // to call it we have to cast the object to Lemur
        System.out.println(primate.hasHair());

        //since all the objects inherit java.lang.Object, we can do this:
        Object o = new Lemur(); // it is still a Lemur but we cant access lemur`s special properties, so the TYPE OF REFERENCE DETERMINES WHICH PROPERTIES WE CAN ACCESS
        Lemur newLemur;
        newLemur = o; // oh shit, o is an object and Java isn`t sure if it will be fine (what kind of Object is it?? - formal logic)
        newLemur = (Lemur) o; // fine - we explicitly told Java we wanna cast it

        // child -> parent   no cast (fine)
        // parent -> child   explicit cast (runtime error might appear if a real object is not a type (subtype) of casting class)
        // unrelated types   compiler error (no chance)

        PrimateClass prima = new PrimateClass();
        Lemur lem = (Lemur) prima; // here is a problem - prima is REALLY a PrimateClass and therefore at runtime will throw a ClassCastException
        prima = new Lemur();
        lem = (Lemur) prima; // that`s fine - prima is Lemur, which we called a PrimateClass, and we can "uncall" it
    }
}

// -----

class BirdClass {
    public String getName() {
        return "Unknown";
    }
    public void displayInformation() {
        System.out.println("The bird name is: " + getName()); // it will call Peacock`s implementation cause it is not static
    }
}
class Peacock extends BirdClass {
    public String getName() {
        return "Peacock";
    }
    public static void main(String[] args) {
        BirdClass bird = new Peacock(); // the BirdClass does not know about his child, but at runtime getName() is replaced cause in fact it is peacock
        bird.displayInformation(); // The bird name is Peacock
    }
}
class Hen extends BirdClass {
    public String getName() {
        return "Hen";
    }
}
// polymorphic parameters
class ZooWorker {
    static void feed(BirdClass bird) { // smth which is a Bird (u can do the same with interfaces)
        System.out.println("Feeding bird " + bird.getName());
    }
    public static void main(String... args) {
        feed(new Hen());
        feed(new Peacock());
        feed(new BirdClass());
        feed(new Object()); // oh, it is not a BirdClass. We can cast it here, but will get an exception at runtime..
    }
}
