package exceptions;

public class Ex {
    // Error usually means smth fatal (hard drive suddenly disappeared), Exception - smth unexpected to deal with
    //                                               ---java.lang.Object---
    //                                                |                    |
    //                                     java.lang.Exception          java.lang.Error
    //                                      |               |
    //   java.lang.RuntimeException (unchecked exception)   other exceptions(checked exceptions)


    void method() throws Exception { //throwS is a declaration (it might throw)
        throw new Exception(); // throw is a commend - do it now!
    }
}
// well, Exceptions are java.lang.RuntimeException (unchecked) and others (checked).
// java.lang.Exception itself is checked and all of its children are checked too (but not RuntimeException, it is unchecked)

// A method has to handle the CHECKED exception case itself or make it the caller’s responsibility - HANDLE ("try {} catch(Exception e) {} ) OR DECLARE (".. throws Exception")
// u CAN also handle or declare an UNCHECKED exception, but not used to - u CAN just IGNORE it
// java.lang.Errors cant be handled or declared at all

class newCl {
    {
        // if u write the "try" block, u have to add a "catch" or a "finally" (if u wanna use both, set "catch" and after it "finally" in the right order)
        // U cant use "catch" or "finally" without a "try"
        try { // BRACES in try-catch are REQUIRED
            //The try block is also referred to as protected code.
            // If an exception occurs here, "catch" will catch it
            throw new Exception("Oh");
            System.out.println(); // we will never get here
        } catch (RuntimeException e) {// any type here
            System.out.println();
        } catch (Exception e) { // if the exception was not Runtime(see "catch" above), we will catch it here

        } finally {
            System.out.println("ALWAYS!!!");
            //The FINALLY block ALWAYS executes, whether or not an exception occurs in the try block.
            // but actually there is a case: When System.exit is called in the try or catch block, finally does not run. Nothing runs after such command
        }
        // after handling the exception proceed here
    }
}