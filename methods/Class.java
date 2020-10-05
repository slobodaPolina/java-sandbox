package methods;

public class Class {
    // pay attention to the order - access modifier + optional(s) + return type + name + parameter(s) + exception(s)
    public static final void nap(int... minutes) throws InterruptedException, IllegalAccessException {

        //optionals
        static // can be called without creating an instance of the class. That means we dont require the state or it is shared
        abstract
        final // it will never be changed (well primitives will not change, instance vars will point to the same instance but inner fields can be changed) since was initiaized

        // if the return type is void you can return nothing ("return;") or omit return statement
        // in other cases you ALWAYS have to return something (in all the branches of the if/switch and so on)

        int... minutes // it is a vararg. Vararg has to be the last arg in the list of args
        // when u call the method u can pass an array into it or pass several values and Java will create an array itself.
        // U can also omit it and the method will receive an array of length 0. Or pass 'null' and it will receive null
        System.out.print(minutes[4]);
    }
    {
        try {
            nap(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public // The method can be called from any class.
protected //The method can only be called from classes in the same package or subclasses. Protected - not everybody, only somehow related classes (see protectedExample)
Default (Package Private) // The method can only be called from classes in the same package. There is no keyword for default access (u just omit it).
private // The method can only be called from the same class.

class Class2 {
    static long field = 9;
}

class Class3 {
    {
        Class2 c = new Class2();
        System.out.println(Class2.field); // ok - we just call static without an instance
        System.out.println(Class2.field); // here Java just checks the type of "c" and replaces it with "Class2.field"
        c = null;
        System.out.println(c.field); // it is ok! the output is 9 because STATICS do not require the instance- it even can be null
        // and also remember that statics are common for all the instances
        c = new Class2();
        c.field = 88;
        Class2.field = 6;
        System.out.println(c.field);// 6 because it is the only field (it was 9 then 88 then 6)
    }
}

class Static {
    private String name = "Static class";
    public static void first() { }
    public static void second() { }
    public void third() { System.out.println(name); }
    public static void main(String args[]) {
        first();
        second();
        third(); //A static member cannot call an instance member. If you once static, you always will. U can create an instance of the class and call using it
    }

    // we have instance initializers (just brackets to be called before the constructor)
    // we also have static initializers (to be called then the class is first used)
    static {
        // anything here
    }
}