package coreAPI;

public class Arrays {
    //An array is an area of memory on the heap with space for a designated number of elements
    // and the String is an array of chars, which cannot be changed.
    // the StrBuilder can be changed (array object is replaced with a new bigger array object when it runs out of space)

    // array is not the primitive

    int[] numbers1 = new int[3]; // set all the elements to the default value for that type
    int[] numbers2 = new int[] {42, 55, 99};
    int[] numbers2 = {42, 55, 99}; // wow! short form/ This approach is called an anonymous array. It is anonymous because you don’t specify the type and size.

    int[] numAnimals;
    int []numAnimals2;
    int numAnimals3[];
    int numAnimals4 [];
    int[] ids, types; // even that way.. two arrays
    int ids[], type; // an array and int value

{   String [] bugs = { "cricket", "beetle", "ladybug" };
    String [] alias = bugs; // the same obj
    System.out.print(bugs.equals(alias)); // true. The equals() method on arrays does not look at the elements of the array! it is standard Object method which is equivalent "=="
    System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0
    // [L means it is an array ^)

    //The array does not allocate space for the String objects. Instead, it allocates space for a references to where the objects are really stored/
    // so the array is the link to an array obj, which contains the links to String objects

    String names[]; // points to null
    String names[] = new String[2]; // points to [null, null]

    String[] strings = { "stringValue" };
    Object[] objects = strings;
    String[] againStrings = (String[]) objects;
    againStrings[0] = new StringBuilder();
    objects[0] = new StringBuilder(); // will throw an exception at runtime cause in fact it will be Strings array

    //-----------------------------------------------------------
    // The Arrays class needs to be imported: import java.util.Arrays; (or use it with full name)
    java.util.Arrays.sort(names);

    strings = new String[] {"10", "9", "100"};
    java.util.Arrays.sort(strings); // "10, 100, 9"

    numbers2 = new int[] {1, 3, 6, 8}; // SORTED array!
    java.util.Arrays.binarySearch(numbers2, 6); // 2 (second place)
    java.util.Arrays.binarySearch(numbers2, 9); // no element found.. but we would put it on index 4 (after element 8), so we do negotiating and minus 1 => -4 -1 = -5(the output is -5)

    //Multidimensional Arrays [][]
    int[][] vars1; // 2D array
    int vars2 [][]; // 2D array
    int[] vars3[]; // 2D array.. ufff
    int[] vars4 [], space [][]; // a 2D AND a 3D array. oh no..

    int[][] differentSize = {{1, 4}, {3}, {9,8,7}}; // not the rectangular one
    int [][] args = new int[4][]; // one more way
    args[0] = new int[5];
    args[1] = new int[3];


    //---------------------------------------------

   // Just like a StringBuilder, ArrayList can change size at runtime as needed.
    java.util.ArrayList list1 = new java.util.ArrayList(); // here we reserve default number of slots
    java.util.ArrayList list2 = new java.util.ArrayList(10); // reserved custom place for elements
    java.util.ArrayList list3 = new java.util.ArrayList(list2); // we want to make a COPY of another ArrayList (We copy both the size and contents)
    java.util.ArrayList<String> list4 = new  java.util.ArrayList<String>();
    java.util.ArrayList<String> list5 = new  java.util.ArrayList<>();
    java.util.List<String> list6 = new java.util.ArrayList<>();
    java.util.List<String> list90 = java.util.Arrays.asList("one", "two");

    // .add(elem) returns true everytime
    list1.add("hawk"); // actually list1 contains Objects so no problems
    list1.add(true); // suppose it will be promoted to Boolean.TRUE
    list4.add(true);
    list1.add(1, 56); // insert on the 1-st position (count from zero)

    list1.remove(true); // returns true because the element was removed
    list1.remove("8988"); //returns false
    list1.remove(0); // returns the element which was removed (pay attention here we pass int value!)
    list1.remove(100); // will throw an exception cause there are not such elements

    // take the EXISTING element from the list and set it to smth more.
    list1.set(109, "uuuu");// will throw an exception cause there are not such elements
    list1.set(0, "aa"); // ok, make the 0-th element be "aa" instead of the old value it contained. And it returns that new element again

    list1.isEmpty();
    list1.size();
    list1.clear(); // size is 0, no elems inside

    //This method calls equals() on each element of the ArrayList to see whether there are any matches.
    list1.contains(new int[] {3, 4, 5}); // searching if such an elem contains in the list
    list4.contains(45); // not the problem to check if the list of strings contain an int

    //ArrayList implements toString() to simplify the life
    // and also .equals() to check all the elements and their order
    list1.equals(list2);

    //----------------------------------------------------
    // tricks for numeric primitives: parse... and valueOf (boolean, byte, short, int, long, float, double). Character does not
    int primitive = Integer.parseInt("123"); // parses primitive
    Integer wrapper = Integer.valueOf("123"); // returns wrapper

    int bad1 = Integer.parseInt("a"); // throws NumberFormatException
    Integer bad2 = Integer.valueOf("123.45"); // throws NumberFormatException

    java.util.ArrayList<Integer> list7 = new  java.util.ArrayList<>();
    list7.add(78); // it is autoboxing
    list7.add(new Integer(922));
    int y = list7.get(0); // it will be unboxed or throw NullPointerException

    java.util.List<Integer> numbers = new java.util.ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.remove(1); // ATTENTION! the 1 here is int so we remove the 1st index
    numbers.remove(new Integer(1));  // remove the element "1"

    java.util.Collections.sort(numbers);

    // from list to array
    Object array[] = list1.toArray();
    String[] stringArray = list4.toArray(new String[0]); // 0 here is not that important - the maximum of list4.size() and that parameter is taken as the length of array

    // from array to list.. ups wtf?
    String[] arr = { "hawk", "robin" }; // [hawk, robin]
    java.util.List<String> list = java.util.Arrays.asList(arr); // returns fixed size list (BACKED LIST) linked to an array
    System.out.println(list.size()); // 2
    list.set(1, "test"); // both of them are [hawk, test]
    arr[0] = "new"; // both of them are [new, test]
    list.remove(1); // throws UnsupportedOperation Exception because it is an attempt to change list size
}
}
