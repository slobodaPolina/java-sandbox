package classDesign;

// public or default (NEVER private or protected)
interface Inter { // the word 'abstract' is inserted automatically
    public static final int CONST = 5; // vars are available. "public static final" is assumed (inserted automatically) - so it can`t be abstract or non-public
    // and also the value of var must be set here cause it is "static final". and as it is static it can be used without an instance
    int CONSTANT = Interf.CONSTANT;

    Inter(); // constructor is not allowed
    {
        // initializers are not allowed too
    }

    void m();
    public abstract void met(); // methods can be "public abstract", but is is redundant, actually interface is an abstract class with every method inside "public abstract"!
    void me() {} // the diff with abstract class - we cant provide body (because every method is abstract and abstract methods cant have body)

    // interface cant be created directly cause it is abstract
    // it does not have to have any methods at all (it can be empty)
    // it can`t be final or private (or even protected) cause it is abstract
    // the non-default methods of interface are public and abstract
}

class Cl implements Inter {
    protected void m() { } // the same as with abstract classes, we have to implement methods
        // (but in this case, all of the methods, because all of them by default are abstract)
    // here it marks a problem method was public automatically, become protected (u cant make visibility weaker when overriding)
}

interface Interf extends Inter, Runnable { // INTERFACE CAN EXTEND SEVERAL OTHERS, it inherits all the abstract methods
    // abstract class can implement interface
    // and everytime concrete class implement or extend it, all the abstract methods have to be implemented
    int CONSTANT = 9;
}
// attention! Class EXTENDS ONE class, interface EXTENDS SEVERAL INTERFACES, but class IMPLEMENTS SEVERAL INTERFACES


// if several interfaces, which class do implement, have exactly SAME methods (same name, args, return type, exceptions), it is ok - class will impl them both at the same time
// if the methods in interfaces are different, class will impl each of them (it will be overloading) - no problem
// but if methods are same but have different return types or throw different concrete exceptions - oh no, you can`t implement them both.
    // Even abstract class or interface can`t extend\impl such interfaces. and also combination of such methods in parent abstract class and implemented interface and so on..
interface Inter2 {
    int m();
}
class InnerClass implements Inter, Inter2 {
    public int m() { }
    public void m() { } // u can`t omit one of them - wrong return type - and u can`t implement both - same erasure
}

// -------------------

//default methods
interface NewInter {
    boolean hasScales(); // automatically public abstract, does n`t have body
    default double getTemperature() { // it is concrete and can be overridden if needs to (but not obligated)
        return 10.0;
    }
    // public is inserted automatically into default method of interface (as it is inserted into other declarations of methods in interface) - so no other modifiers allowed
    // Default method can only be declared in interface (never in abstract class - in abstract class u just create a common method instead of abstract one)
    // default methods must have a body, and non-default declarations of methods in interface(abstract ones) must not!
    // default method CAN`T be static/final/abstract (and not assumed to)
}
interface NewInter2 extends NewInter {
    double getTemperature(); // child interface can redeclare default method as abstract mo make own children realise it
    default boolean hasScales() { // and redeclare abstract method to make it default (concrete) for own children
        return true;
    }
    // default method can also be overridden as default one (just to change the default implementation)
    // and the more, abstract one can be redeclared to change modifiers (strange case)
}


// in the case of class with several implemented interfaces with the same default methods it won`t compile until class overrides the method itself
class Cat implements Walk, Run {
    public int getSpeed() { // without this overriding Java will not be sure about version of the method.
        // And this rule will work even with abstract classes implementing 2 similar default methods
        return 1;
    }
    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed());
    }
}
interface Walk {
    public default int getSpeed() {
        return 5;
    }
}
interface Run {
    public default int getSpeed() {
        return 10;
    }
}

// ---- static methods in interface ------
interface In {
    public static void methodd() {
        // static method like everything in interface is public
        // static method of interface has to have a body
    }
}
class ClassIn implements In {
    {
        In.methodd();
        methodd(); // when the class implements an interface, such method will not be inherited - if u wanna call him, call it with the interface name
    }
}