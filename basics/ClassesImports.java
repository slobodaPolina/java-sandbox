package basics;// if package path starts with 'java; or 'javax' - it came with JDK. Rules for naming are the same as variables' ones
import java.util.Random;
import java.lang.*; // Class System (System.out.println) is located in java.lang, but we never write this import - it is the only package that imports automatically
import .*; // u can use only 1 wildcard in the end of package name to import classes from there
// own package is imported automatically (u can use 'neighbours' without importing)
import java.util.*;
import java.sql.*;

/*
ok - 1 or several non-public class(es) in 1 file (and no public one)
but if u write "public" word, the file should be named after this public class
    => no more than 1 public class is allowed in 1 file

after the .java (source code) is ready, call javac to get .class file (bytecode). After that we call java to execute it
for example:
    javac packageName/Zoo.java packageName/Tiger.java packageName/Monkey.java      // and everything else. Omit packageName for default packaged
    java packageName.Zoo                                                           // no .class extension here. Run the class with entry point
 */
public class ClassesImports {
    void method() {
        // static method can be called this way cause it is single; we dont have to create an instance of basics.ClassName
        ClassName.main();
        new Random().nextBoolean();
        HelloWorld.main(new String[]{}); // Java automatically looks in the current package for other classes, so we dont have to import basics.HelloWorld`s package
        new Date(); // oh, little stupid java is not sure which Date it has to use here ("The type Date is ambiguous")
        // to fix it u can import not the whole java.util.*, but concrete java.util.Date (and Java will be sure even if you still have java.sql.* imported)
        // and if you import both java.util.Date and java.sql.Date (concrete both of them) you ofc will get error ("The import java.sql.Date collides with another import statement")
        java.util.Date date; // little trick not to suffer from those imports;)
        java.sql.Date sqlDate;
    }
}

// second public class (oh no)
public class g{}

// non-public - it is ok
class ClassName {
    // In practice, you can write String[] args, String args[] or String...args. And ofc call 'args' any name u like
    public static void main(String...args) { // The characters ... are called varargs (variable argument lists)
        System.out.println(args[0]); // 1st argument in cmd when the program was called
    }
}