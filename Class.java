public class Class {
    // pay attention to the order - access modifier + optional(s) + return type + name + parameter(s) + exception(s)
    public static final void nap(int... minutes) throws InterruptedException, IllegalAccessException {

        //optionals
        static
        abstract
        final

        // if the return type is void you can return nothing ("return;") or omit return statement
        // in other cases you always have to return something

        int... minutes // it is a vararg. Vararg has to be the last arg in the list of args
        // when u call the method u can pass an array into it or pass several values and Java will create an array itself.
        // U can also omit it and the method will receive an array of length 0. Or pass 'null' and it will receive null
        System.out.print(minutes[4]);
    }
}


public // The method can be called from any class.
protected //The method can only be called from classes in the same package or subclasses.
Default (Package Private) // The method can only be called from classes in the same package. There is no keyword for default access (u just omit it)
private // The method can only be called from the same class.


