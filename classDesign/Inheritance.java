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

// ATTENTION! private methods can`t be overridden cause they are not accessible - no rules for them - create anything u like

// rules for overridden methods (methods in parent and child, which have same name and params): if smth is wrong, it will not compile
// 1. accessibility of child method >= accessibility of parent`s
// 2. checked exceptions of child method <= checked exceptions of parent`s
// 3. returned type of child method <= returned type of parent`s (I mean child`s return type if the same or subclass of parent`s return type)

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
        // to return smth the same or smth can be easily mapped, we expect not to throw smth unexpected, we expect to be sure we can access to call the method at all!
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

// Unlike OVERRIDING a method, in which a CHILD METHOD totally REPLACES THE PARENT METHOD in calls defined in both the parent and child,
// HIDDEN methods only REPLACE parent methods in the CALLS defined in the CHILD CLASS.

class Parent {
    public static String stMethod() {
        return "Parent";
    }
    public void callParentStatic() {
        System.out.println("Called static method from parent class: " + stMethod()); // it only knows about isBiped() from its own class definition
        // the parent version of a hidden method is always executed if the call to the method is defined in the parent class
    }
    // ---------
    public String nonStMethod() {
        return "Parent"; // is not called
    }
    public void callParentNonStatic() {
        System.out.println("Called non-static method from parent class: " + nonStMethod()); // it is replaced at runtime in the parent class with the call to the child class’s method
    }
    // ---------
    String var = "Parent";
    public void getParentVar() {
        System.out.println("Called var from parent class: " + var);
    }
}

class Main extends Parent {
    public static String stMethod() { // hidden method (overridden static)
        return "Child";
    }
    public void callChildStatic() {
        System.out.println("Called static method from chld class: " + stMethod()); // it uses own method
        // use super.stMethod() to get parent`s one from here
    }
    // ------
    public String nonStMethod() { // overridden method
        return "Child";
    }
    public void callChildNonStatic() {
        System.out.println("Called non-static method from child class: " + nonStMethod());  // it uses own method
        // use super.nonStMethod() to get parent`s one from here
    }
    // ------
    String var = "Child";
    public void getChildVar() {
        System.out.println("Called var from child class: " + var);
        // use super.var to get parent`s value from here
    }

    // -------
    public static void main(String[] args) {
        Main joey = new Main();
        // statics (hidden methods) - if called from the child class, child method used. If called from parent`s - parent`s
        joey.callParentStatic(); // "Called static method from parent class: Parent"
        joey.callChildStatic(); // "Called static method from child class: Child"

        // non-statics (overriding) - only child version of the method is called
        joey.callParentNonStatic(); // "Called non-static method from parent class: Child"
        joey.callChildNonStatic(); // "Called non-static method from child class: Child"

        // variables (hiding) - the same as static methods
        // attention! no diff if the ver is static or not - the behaviour is the same
        joey.getParentVar(); // "Called var from parent class: Parent"
        joey.getChildVar(); // "Called var from child class: Child"


        // ufff
        // well in the end u have to pay attention to the type of reference
        Parent parent = new Main();
        System.out.println(parent.var); // "Parent" (reference type is parent, does not matter the object actually stored)
        Main main = new Main();
        System.out.println(main.var); // ofc "Child"
    }
}
