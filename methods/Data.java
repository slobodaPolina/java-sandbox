package methods;

public class Data {
    protected void method(int val, String name, StringBuilder sb) {
        val = 4; // here we pass by value, so method has own copy and do not change original variable
        name = "John"; // hmm here again..? name is passed by value
        sb.append("new piece"); // it is the same one sb - we pass it (object) by reference
    }
    {
        int h = 9;
        String name = "Webby";
        StringBuilder sb1 = new StringBuilder();
        method(h, name, sb1); // h remains 9, name remains "Webby", but sb changes
        System.out.println(h + name);
    }

    // overloading - u create several methods with the same name but DIFFERENT PARAMS (and additionally u can vary access, exceptions, specifiers, return types)
    void fly(int[] lengths) { }
    void fly(int... lengths) { } // attention - here technically is possible Java won`t be sure what to call then receives "fly(new int[5])"

    void fly(int numMiles) { }
    void fly(Integer numMiles) { } // thats ok- when calling fly(5) it will be parsed as int

    void trick(String s) {}
    void trick(Object o) {} // well now if u call it with String, the "String" (the most specific) version will be called
    // and one more - java is able to convert int to long and long to Long but not int to Long (it will take 2 steps)
    // so we cant call the method (Long l) passing 9 for example
}