package methods;

public class Data {
    protected void method(int val, String name, StringBuilder sb) {
        val = 4; // here we pass by value, so method has own copy and do not change original variable
        name = "John"; // PAY ATTENTION! name is a ref which looks to the "Webby". Then we call a method, we copy a ref - so it is second ref to the one obj
        // after all, we make this second ref to look to the new object "John". Old ref from that previous method stays the same (and "Webby" stays the same)
        sb.append("new piece"); // sb is a new second ref to stringbuilder obj. We change it here- so this object available with old sb1 link is changed
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