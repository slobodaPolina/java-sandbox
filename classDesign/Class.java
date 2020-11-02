package classDesign;

class Animal {
    int age;
    public int getAge() {
        return age;
    }
}

public class Class extends Animal {
    // Java allows only single inheritance
    // if the class marked as FINAL, we CAN`T INHERIT it
        // if the field is FINAL, CAN`T REASSIGN it,
        // if the method is FINAL, CAN`T OVERRIDE OR HIDE(if static) it.
    // if the class inherit nothing, it will automatically inherit class Object
    {
        getAge(); // can call parent`s protected and public methods and vars
    }

    public Class() {
        super(); // call to direct parent`s constructor. Like the this() command, super() has to be first one in the constructor
    }
    public Class(int y) {
        this(); // call to own another constructor
    }
}

// ------------------------

class Mammal {
    public Mammal(int age) { // this constructor kills the default one))
    }
}
class Elephant extends Mammal {
    // super() with no args is added in child`s constructors at the first line if no other super(...) or this(...) is written
    // so parent class always has to have the default constructor (it can have none and the default will be generated)
    // or u can create child`s constructor with some super(...) call yourself
    public Elephant(int y) {
        super(y);
    }

    public Elephant() {
        // super() is inserted automatically so Java tries to call Mammal() with no args but there is no such constructor
    }
}

// ---------------------------

// as the first line is super ANYWAY, when u create an instance of child, the parent`s constructor is called at the beginning - pay attention!
class Primate {
    public Primate() {
        // super()
        System.out.println("Primate");
    }
}
class Ape extends Primate {
    public Ape() {
        // super()
        System.out.println("Ape");
    }
}
class Chimpanzee extends Ape {
    { // lets start from here! call own constructor - is is the default one. It means it contains only super() command.
        // so we call Ape(). in the first line super() is generated so we call Primate() - the output is "Primate Ape"
        new Chimpanzee();
    }
}
