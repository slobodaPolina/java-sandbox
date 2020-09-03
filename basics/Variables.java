package basics;

public class Variables {
    public int method() {
        int t; // Local variables must be initialized before use. They do not have a default value
        return t; //and they cannot be used outside the the own block
    }
    public void findAnswer(boolean check) {
        int answer;
        int onlyOneBranch;
        if (check) {
            onlyOneBranch = 1;
            answer = 1;
        } else {
            answer = 2;
        }
        System.out.println(answer); // clever enough to understand it is initialized anyway
        System.out.println(onlyOneBranch); // there is possibility of that var not to be initialized
    }
    // ------------------------------------------
    int y; // instance variable, also known as field - exists until the end of class instance lifetime
    static int z;// class variables - they are always available (from declaration until the end of program)
    // Instance and class variables do not require you to initialize them - they have default values (null, 0, false)

    //Java objects are stored in your program memory’s heap- it is large but limited
    // GarbageCollector will delete everything is no longer reachable
    public static void main(String[] args) {
        System.gc(); //is not guaranteed to run, it suggests to run it (but Java can ignore it)
        // object is no longer reachable (eligible for garbage collection) when
        //■ The object no longer has any references pointing to it.
        //■ All references to the object have gone out of scope
    }

    //gets called if the garbage collector tries to collect the object
    // it might not get called at all and it definitely won’t be called twice (even if Java tried to remove obj and failed the attempt - it will not call finalize then will do the removal again)
    protected void finalize() {}

    /*
    KEY BENEFITS of Java
        Object Oriented
        Encapsulation- access modifiers to protect data/ Access modifiers allow classes to encapsulate data
        Platform Independent - write the code once, interprete into .class (bytecode) and run everywhere
        Robust - prevents memory leaks. Java manages memory on its own and does garbage collection automatically
        Simple - simpler than C++. In addition to eliminating pointers, it got rid of operator overloading.
        Secure - Java code runs inside the JVM. This creates a sandbox that makes it hard for Java code to do evil things to the computer it is running on
     */
}
