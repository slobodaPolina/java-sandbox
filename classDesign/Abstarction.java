package classDesign;

abstract class MyAnimal {
    protected int age;
    public void eat() {
        System.out.println("Animal is eating");
    }
    public abstract String getName(); // u can specify abstract methods in abstract class(or can not if u don`t want to)
    // notice here we omit body and put semicolon instead! ABSTRACT METHODS NEVER HAVE BODY
}

class Swan extends MyAnimal { // the class which directly extends abstract, has to implement(override) all the abstract methods of the parent
    // such class is called CONCRETE class
    public String getName() { // implementation of abstract method (same signature as for overriding)
        eat(); // that method is not abstract, so it is fine
        System.out.println(age);
        return "Swan";
    }
}

// this concrete class really has to implement all the abstract methods from parent if you gonna use it
// so implement or continue this abstract chain^) I mean abstract class can extend another abstract class and does not has to override parent abstract methods
// but if u create a concrete class extends that one, the concrete class will override all the abstract methods in this chain (parent`s, grandparrent`s and so on)
// little tip: actually if abstract method from grandpa was implemented in abstract parent, concrete class might omit own implementation:
abstract class GrandPa {
    abstract void method();
}
abstract class Pa { // it inherits all the methods from parent, including abstract, and can implement them to make them concrete
    void method() { // implements abstract method itself, so at least 1 implementation exists
        return;
    }
}
class Concrete {} // it compiles! the main idea is by the time we use the class (the chain becomes concrete), we have to have an implementation (it can be extended).
// If no implementation found, it will not compile

// ----------------------------------------------------------

class Tiger extends MyAnimal { // has to be abstract or override all the methods
    abstract void method() {} // ABSTRACT METHOD HAS TO BE IN ABSTRACT CLASS, but abstract class is not forced to contain abstract methods
}

abstract final class Fatal {} // abstract class can never be final (haha what is the reason for its existence?) or private (i am not sure if classes can be private at all_
// abstract methods can never be final and can never be private for the same reason (what for? they will not be available to override)
// so neither abstract classes nor abstract methods inside them can be private or final

abstract class Test {
    public static void main(String[] args) {
        Test test = new Test(); // ofc we cant create an istance of abstract
    }
}
