package methods;

import java.util.List;
import static java.util.Arrays.asList; // import it and use then we call "asList" (pay attention - no method parameters here, it will import all the similar named methods)
import static java.util.Arrays.*; // import all statics from there

import static java.util.Arrays; // No, we cant import class statically. ONly static members (fields and methods)
static import java.util.Arrays.*; // pay attention to the order - import static!

public class StaticImports {
    public static void main(String[] args) {
        List<String> list = asList("one", "two"); // asList is a static member of Arrays
        Arrays.asList(); // hah.. we did not import the class Arrays himself so it is ok to write asList, but not Arrays.asList
    }
}