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

// A method has to handle the CHECKED exception itself or make it the caller’s responsibility - HANDLE ("try {} catch(Exception e) {} ) OR DECLARE (".. throws Exception")
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
            System.out.println(); // we will never get here (and cannot write such code)
        } catch (RuntimeException e) {// any type here (even unchecked)
            System.out.println();
        } catch (Exception e) { // if the exception was not Runtime(see "catch" above), we will catch it here

        } catch (ArithmeticException e) { //the order of exceptions is important - such exception is Exception and was already caught! exception cant be caught more then once

        } finally {
            System.out.println("ALWAYS!!!");
            //The FINALLY block ALWAYS executes, whether or not an exception occurs in the try block.
            // but actually there is a case: When System.exit is called in the try or catch block, finally does not run. Nothing runs after such command
        }
        // after handling the exception we proceed here
    }


    public String exceptions() {
        String result = "";
        String v = null;
        try {
            try { // u can add another try-catch into any block (it is ok)
                result += "before";
                v.length(); // oh NPE !!
                result += "after"; // we will not reach it
            } catch (NullPointerException e) {
                result += "catch";
                throw new RuntimeException();// throwing one more ex (oh)
            } finally {
                result += "finally"; // finally is ALWAYS called even if one more ex was thrown in the catch block
                throw new Exception(); // Runtime exception was hidden by this exception (we rethrow it)
            }
            // ufff.. we dont reach here cause the ex was thrown ("Exception" one)
        } catch (Exception e) {
            // we go here strait from finally because we got an Exception
            result += "done";
        }
        // fine - everything handled (yeap, we lost that RuntimeException)
        return result;
    }
}