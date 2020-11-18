package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Types {
    private void me() throws ArithmeticException, StackOverflowError { // wow, compiler lets throw, handle handle and declare an Error but it is not a good practice
        // RUNTIME EX (if u want to, u can ignore, handle or declare them)
        // these can be thrown by JVM or programmer
        throw new ArithmeticException(); // JVM throws when x / 0
        throw new ArrayIndexOutOfBoundsException(); // JVM throws then tries to call by illegal index of the array
        throw new NullPointerException(); // JVM throws then u try to call fields or methods of null (do u remember static ones are OK?)
        throw new ClassCastException(); // JVM throws then u try to cast unrelated classes

        throw new IllegalArgumentException(); //can be thrown by programmer (not JVM) then smth unexpected was sent to a method (kind of convention)
        throw new NumberFormatException(); // programmer?.. then u try to parse bad String as a number (Integer.parseInt("Ha-ha")) - in fact a subclass of IllegalArgumentException

        // CHECKED EX (HANDLE OR DECLARE!!! even if u call a method which declared this ex but actually never throws it)
        // these 2 are thrown by programmer
        throw new IOException(); // any input-output problem
        throw new FileNotFoundException(); // subclass of IOException

        // ERRORS (u can do nothing)
        throw new ExceptionInInitializerError(); //Java runs static initializers the fi rst time a class is used. If one of the static initializers
                // throws an exception, Java can’t start using the class and rethrows an Exception-In-Initializer-Error.
                // Java failed to load the whole class. This failure prevents Java from continuing.
        throw new NoClassDefFoundError(); //occurs when Java can’t find the class at runtime (but found at compile time)
        throw new StackOverflowError(); // Java`s stack is full of params and local variables - probably you are doing infinite recursion

        try {
            System.out.println();
        } catch(IllegalArgumentException e) { // here is ok (but System.out.println() declared nothing to throw!) - because it is unchecked - method can throw it without declaration

        } catch (IOException e) { // it is a little problem - here the compiler is sure such exception cant be thrown (because it is checked. No declaration means it cant be thrown)

        }

        // and u can declare everything u want - and dont throw anything - it is legal
        // do u remember - when we override interface`s or superclass`s method, we cant add new CHECKED exceptions? because user does not know about every implementation
        // u can declare the same exceptions as in the parent method - and throw or dont throw them, u can declare less or declare nothing if u dont need to
        // u can declare more specific exceptions - it is ok. U can throw any runtime ex with declaring them or without declaring
        // Just never throw unexpected checked exceptions!


        //dealing with exceptions:
        try {
            // some throwing code
        } catch (Exception e) {
            System.out.println(e.getMessage()); // only message
            System.out.println(e); // exception class + exception message
            e.printStackTrace(); // class + message + full stack trace
        }
    }
}

// REMEMBER
// u can always throw an unchecked ex without declaring it and add them to declaration of overridden methods (remember unchecked exceptions means nothing at all)
// remember to check u are not catching parent before child, so child becomes unreachable
// if in a try block u call a method which didn`t declare CHECKED exceptions, and u don`t throw them yourself, compiler understands there is no way for them to appear
        // so then u try to catch them, u write unreachable code.
        //(tip - "catch (Exception e)" is OK, because Exception includes checked and unchecked exceptions and u can use it to catch all the unchecked ones)
        // but if u write smth kind of "IOException" u definitely mean CHECKED one - error
// strange case.. u can handle, throw and declare anything of type Exception, even Errors - but it seems bad practice. But still u can. in part of questions they mean "no", in part - "yes"