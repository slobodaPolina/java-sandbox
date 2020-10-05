package operatorsStatements;

public class Constructor {
    public Constructor() {} // this is a constructor - the NAME is exactly THE SAME as class`s, NO RETURN TYPE provided
    void Constructor() {} // this is not
    public constructor() {} // this is not again

    // when u write the word new, the constructor is called

    String field;
    void anyMethod(String field) {
        this.field = field; // when such a collision occurs, Java supposes the closest variable (so field is a method param, to get the instance var u have to type this.)
    }

    // if u did not provide the class with a constructor, Java will do it for u
    // pay attention if u have any constructor (even private one), Java wont create the default one!

    //calling the constructor
    // as I said u can call it by saying new Constructor()
    // and if u wanna call one constructor from the other, u will call this():
    public Constructor(int u) {
        System.out.println();
        this(u, 5); // Call to 'this()' must be first statement in constructor body.. sorry
    }
    public Constructor(int u, int h) {
        // initialization
    }


    // INITIALIZATION ORDER
    // 1. If there is a superclass, initialize it first
    // 2. Static variable declarations and static initializers in the order they appear in the file
    //   2.5. If the file was initializing automatically because static method of that class was called from outside, here we stop initialization and omit 3 and 4.
    //   if afterwards this class will be initialized normally with the "new" initialization will continue using the 3 and 4
    // 3. Instance variable declarations and instance initializers in the order they appear in the file
    // 4. The constructor
}