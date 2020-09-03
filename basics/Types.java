package basics;

public class Types {
    // primitives are stored in the memory
    boolean a = true;
    byte b = 127; // 8 bit [-2^7; 2^7)
    short c = 32767; // 16 bit [-2^15; 2^15)
    char d = 'e'; // 16 bit unicode
    int e = 2147483647; // 32 bit - around 2 billion - [-2^31; 2^31)
    float f = 12.4f; // 32 bit - and dont forget the f in the end
    double g = 1.6; // 64 bit
    long h = 4611686016279904000L; //[-2^63; 2^63) - and dont forget the L in the end cause by default, Java assumes you are defining an int

    // -------
    static int binary = 0b100; // if u start with prefix 0b (or 0B) java will parse it as a binary (base 2) - here it is 4 (0 + 0 * 2 + 1 * 2^2)
    static int octal = 017; // if u start with the 0 java will parse it as an octal (base 8) - here is 15 (7 + 7 * 8^1)
    static int hexadecimal = 0xff; // if u start with prefix 0x (or 0X) java will parse it as a hexadecimal  (base 16) - here it is 255 (15 + 15 * 16^1)

    public static void main(String[] args) {
        System.out.println(binary + octal + hexadecimal); // even if u initialize that way they are parsed as normal decimal ints)) and u get decimal response
    }
    // --------
    double notAtStart = _1000.00;
    double notAtEnd = 1000.00_;
    double notBeforeDecimal = 1000_.00;
    double notAfterDecimal = 1000._00;
    double annoyingButLegal = 1_00_0.0_0;
    double ideal = 2_000_978_034.89; // just to make the life easier (for any type)

    int y = null; // primitives cant be null
    int test = ideal.method(); // Primitives do not have methods

    //----------------------------------------------
    // Classes (reference types) store a pointer to the value in the memory (and the value somewhere else in the heap)
    String greeting = "murr"; // actually is a reference (pointer, link) that can only point to a String object.
    String i = null; // null means reference does not currently refer to an object
    String q = greeting.toString(); // reference types do have methods

    //----------------------------------------------
    String j; // declaration
   {
       j = "jd"; // initialization
   }
   // it can be done in 1 line for several vars
    String s1, s2; // in one declaration u can declare several vars of ONE type
    int num, String value;
    String s3 = "yes", s4 = "no";
    int i1, i2, i3 = 49; // declare 3 vars but initialize only i3! the i1 and i2 are not yet initialized!

    // little tricks
    boolean b1, b2;
    String s1 = "1", s2;
    double d1, double d2;
    int i1; int i2;
    int i3; i4;
}
