package coreAPI;

import java.util.Date;

public class Strings {
    String name = "Fluffy"; // String class is special and doesn’t need to be instantiated with "new". it is the pool method of initiating
    String name2 = new String("Fluffy"); // not the pool one

    //string concatenation
    String nameName = name + name2;
    { nameName += 3; } // 3 becomes "3" and concatenates
    {
        // left to right - if both are nums - it is an addition, if one of them is string - concatenation
        System.out.println(1 + 2); // 3
        System.out.println("a" + "b"); // ab
        System.out.println("a" + "b" + 3); // ab3
        System.out.println(1 + 2 + "c"); // 3c
    }
    public static void main (String args[]) {
        System.out.println('d' + 'd'); // hah, it is 200 cause the are chars, which become ints (dont u remember?)
    }

    // mutable = changeable
    // immutable = non changeable
    class Mutable {
        private String s;
        public void setS(String newS){ s = newS; } // Setter makes it mutable
        public String getS() { return s; }
    }
    final class Immutable {
        private String s = "name";
        public String getS() { return s; }
    }

    {

        // strings are immutable! not changeable. when u change it, u recreate it
        String s1 = "1";
        String s2 = s1.concat("2"); // s1 remains the same ("1"), s2 is "12"
        s2.concat("3"); // we do not save it into s2, so s2 remains unchanged (all the methods below do that)
        System.out.println(s2);

        //The string pool contains literal values that appear in your program.
        String name = "Fluffy"; // uses string pool (and not collected by gc)
        name = new String("Fluffy"); // does not use the string pool (and ofc some others .toString() and etc)

        name.length();
        name.charAt(0); // from 0 to .length() - 1

        name.indexOf('f');
        name.indexOf("ff");
        name.indexOf('f', 4);
        name.indexOf("ff", 4); // all of the indexOf methods return -1 if nothing found

        name.substring(0, 6); // from 0 to .length() (here we set the index before the symbol, so .length() takes the end of str)
        name.substring(3); //omit first 3 symbols and take everything until the end
        name.substring(1, 1); // empty
        name.substring(1, 7); // exception (more than .length())
        name.substring(3, 2); // exception (wrong order)

        name.toLowerCase();// converts only letters
        name.toUpperCase();

        "abc".equalsIgnoreCase("ABC");
        "abc".equals("abc");

        "abc".startsWith("a"); // here the case is important
        "abc".endsWith("c");
        "abc".contains("b");

        "abcabc".replace('a', 'A');
        "abcabc".replace("a", "A");// two chars or two Strings
        "\t     a b c\n".trim(); // "abc" - remove all the whitespaces

        "AniMaL     ".trim().toLowerCase().replace('a', 'A'); // u can combine them (CHAINING)

        //===============================================================================================
        // every time u concat the string, new obj is created instead of old one
        String alpha = "";
        for(char current = 'a'; current <= 'z'; current++)
            alpha += current;

        // StringBuilder is NOT immutable
        StringBuilder al = new StringBuilder();
        for(char current = 'a'; current <= 'z'; current++)
            al.append(current); // it changes the al variable (not recreating vars)
        System.out.println(al);

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");//it IS changing 'a' object and also returns it so 'a' and 'b' are the same obj
        b = b.append("f").append("g");
        System.out.println("a=" + a); // BOTH are "abcdefg" cause a and b are the same one obj:
        // stringBuilder is created only once and then after 'append' it changes itself and returns the link to itself (so a and b are the link to the obj)
        System.out.println("b=" + b);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("animal");
        StringBuilder sb3 = new StringBuilder(10); // size is the current length - the chars stored. Capacity is the reserved space

        sb1.charAt(0);
        sb1.indexOf("n"); // here we can use only strings (in the string.indexOf chars were possible)
        sb1.length();
        sb1.substring(0, 1); // returns a string! so does not change the SB!!! pay attentions - others methods do change it
        sb1.append(7).append('n').append(9f).append(true).append(new Date()); // everything
        sb1.insert(4, "-"); // index and value
        sb1.delete(0, 4); // delete symbols from the start to the end
        sb1.deleteCharAt(7);
        sb1.reverse();
        sb1.toString();// returns a string! so does not change the SB

        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        StringBuilder three = one.append("a"); // 'one' gets 'a', and 'three' contains the 'one' value (same object)
        System.out.println(one == two); // false
        System.out.println(one == three); // true
        one.equals(two); // equals for SB was not overriden and ot means the same as "==" (so here it is false)

        String x = "Hello World";
        String y = "Hello World";
        System.out.println(x == y); // true (string pool)

        x = "HelloWorld"; // without whitespaces
        String z = " Hello World".trim();
        System.out.println(x == z); // false! they equals but not the same (z is calculated, x in the pool)

        z = new String("Hello World");
        System.out.println(y == z); // false (but equals)

        // the class which do not override equals does equals as '==' (means not equality but the same obj)
    }
}
