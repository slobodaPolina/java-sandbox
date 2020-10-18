package classDesign;

public class Inheritance {
    //Child classes may use any public or protected member of the parent class.
    //If the parent class and child class are part of the same package, the child class may also use any default members defined in the parent class.
    //Finally, a child class may never access a private member of the parent class, at least not through any direct reference.

    //then u call parent`s public or protected method or variable, u can call it directly as own method/variable (and even use "this." or "super.")
    int age;
    int getAge() {
        return 10;
    }
}

class Child extends Inheritance {
    {
        int age = super.age; // call parent`s one using "super."
        age = this.age; // call it using "this." - it calls parent`s one cause there is no own and that`s ok
        // "super" is used ONLY for PARENT`S members and constructor (if we write "super", we call parent)
        // "this" is used for OWN or PARENT`S members and own constructor (if we write "this", it might be own or parent)
    }
    // we override it (parent`s method) .. do u remember - methods, which have one name, but different params are overloaded, with same params - overridden
    int getAge() {
        return super.getAge() + 1; // here we write "super." to mark we wanna call parent`s method. If we omit it or use "this" instead, it will be infinite loop!
    }

    {
        new Child().getAge(); // it will be 11 (10 + 1) cause it is overridden method (specified version of it, the most concrete one)
        new Inheritance().getAge(); // 10 of course (Inheritance does not have any others)
    }
}

// ------------------------------------------------

// ATTENTION! private methods can`t be overridden cause they are not accessible - no rules for them
// rules for overridden methods (methods in parent and child, which have same name and params): if smth is wrong, it will not compile
// accessibility of child method >= accessibility of parent`s
// checked exceptions of child method <= checked exceptions of parent`s
// returned type of child method <= returned type of parent`s (I mean child`s return type if the same or subclass of parent`s return type)

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
    public void eat(int food) {
        System.out.println("Bird is eating " + food + " units of food");
    }
}
class Eagle extends Bird {
    public int fly(int height) { // this is overloaded method - same name but different params - so no rules here and everything is fine
        System.out.println("Bird is flying at " + height + " meters");
        return height;
    }
    public int eat(int food) { // it is overridden - name and params are the same. There are rules, at least return type should be same or subclass, but "int" is not "sub-void"
        // it means then we call concrete version of parent`s method, we expect it to behave the same way -
        // to return smth the same or smth can e easily mapped, we expect not to throw smth unexpected, we expect to be sure we can access to call the method at all!
        System.out.println("Bird is eating " + food + " units of food");
        return food;
    }
}

// --------------------------------------------------------

//what about STATICS?: all the same rules + u cant omit the modifier "static" while overriding (the child`s method has to keep "static")
// it is easy. As in the previous part, when we use overridden method, we expect the same behaviour. If we used that method in a static way (without an instance),
// we obviously have to have ability to use child`s one in the same manner

class Bear {
    static void sneeze() {
        System.out.println("Bear is sneezing");
    }
    void hibernate() {
        System.out.println("Bear is hibernating");
    }
}
class Panda extends Bear {
    void sneeze() { // don`t loose the "static" modifier
        System.out.println("Panda bear sneezes quietly");
    }
    static void hibernate() { // and u cannot insert "static" modifier neither (but actually I don`t know there is the problem)
        System.out.println("Panda bear is going to sleep");
    }
}


// it is called "hiding", new static methods 'hide' the old ones and it is not called overriding
// Unlike overriding a method, in which a child method replaces the parent method in calls defined in both the parent and child,
// hidden methods only replace parent methods in the calls defined in the child class.

class Marsupial {
    public static boolean isBiped2() { // static method
        return false;
    }
    public void getMarsupialDescription2() {
        System.out.println("Marsupial walks on two legs: " + isBiped2()); // it only knows about isBiped() from its own class definition
        // the parent version of a hidden method is always executed if the call to the method is defined in the parent class
    }
 // ---------
    public boolean isBiped() { // non-static method
        return false;
    }
    public void getMarsupialDescription() {
        System.out.println("Marsupial walks on two legs: " + isBiped()); // it is replaced at runtime in the parent class with the call to the child class’s method
    }
}

class Kangaroo extends Marsupial {
    public static boolean isBiped2() { // hidden method (overridden static)
        return true;
    }
    public void getKangarooDescription2() {
        System.out.println("Kangaroo hops on two legs: " + isBiped2()); // it uses own method
    }
 // ------
    public boolean isBiped() { // overridden method
        return true;
    }
    public void getKangarooDescription() {
        System.out.println("Kangaroo hops on two legs: " + isBiped());  // it uses own method
    }
 // ------
    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();
        joey.getMarsupialDescription2(); // "Marsupial walks on two legs: FALSE"
        joey.getKangarooDescription2(); // "Kangaroo hops on two legs: TRUE"

        joey.getMarsupialDescription(); // "Marsupial walks on two legs: TRUE"
        joey.getKangarooDescription(); // "Kangaroo hops on two legs: TRUE"
    }
}
