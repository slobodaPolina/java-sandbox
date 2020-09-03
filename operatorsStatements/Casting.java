package operatorsStatements;

public class Casting {
    // BINARY OPERATORS
    int x = 1;
    long y = 33;
    int z = y * x; // If two values have different data types, Java will automatically promote one of the values to the larger of the two data types

    double a = 39.21;
    float b = 2.1f;
    float c = a * b;

    //---------------------
    int d = 8;
    float e = 1.5f;
    int f = d * e; // If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point value’s data type

    //---------------------
    short g = 10;
    short h = 3;
    short i = g / h;  // Smaller data types, namely byte, short, and char, are first promoted to int any time they’re used with a Java binary arithmetic operator, even if neither of the operands is int.
    short j = g++; // unary operators are excluded from this rule
    // After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands
    // --------------------------

    // UNARY OPERATOR is one that requires exactly one operand, or variable, to function
    double k = -5;
    boolean l = false;
    {
        // each one has own unary operators
        k = -k;
        ++k; --k; // pre-increment operator and the pre-decrement operator (the operator in expression is applied first)
        k--; k++; // post-increment operator and the post-decrement operator (in exp we use original value and increase/decrease value afterwards)
        k = !k;
        l = !l;
        l++;
        l = -l;

        int m = 3;
        int n = ++m * 5 / m-- + --m; // hmm.. firstly we get rid of pre- and post- operators, simplifying:
        n = 4 * 5 / 4 + 2; // ++m returns 4 into exp (pre-), m-- returns 4 into exp and then x becomes 3 (post-), --m returns 2 into exp (pre-)


        // TERNARY OPERATOR
        System.out.println((y > 5) ? 21 : "Zebra");
    }

    public static void main(String[] args) {
        int x = 1.0;
        int v1 = (int)1.0; // if we write double and assign it to non-point type or assign big value to small type we got error and have to cast it
        byte v2 = 20000000;
        byte v3 = (byte) 22000000; // it will cut off everything bigger then the type size (numeric overflow occurs)
        int v4 = (int)9L;
        int v5 = Integer.MAX_VALUE + 1; // becomes Integer.MIN_VALUE
        v5 += 1; // compound assignment operator
        long v6 = 2L;
        v5 *= v6; // .. but why no error? compound assignment operator does all the casting for u (v5 casts to long, multiplies and then casts back to int cause type of v5 is int)

        long v7 = (v6 = 3); // both of them become 3 - hmm, automatic casting again?


        boolean tr = true;
        boolean fl = false;
        fl = tr & fl; // logical "and" - everyone is true
        tr = tr | fl; // logical inclusive "or" - one or more is true
        tr = tr ^ fl; // logical exclusive "or" - only one and no more than one is true

        int yyy = 49; // anything
        // SHORT-CIRCUIT OPERATORS - the same as logical ones above
        // BUT in their case compiler can simplify the exp and omit the right-hand part of exp if it is sure about the result (look above - var yyy is redundant). Try to remove one "|" from exp below:
        boolean x = true || (yyy < 4); // actually it is obvious that (true || ???) is always true
        // common illustration - check if not null and never throw an exception
        String sss = null;
        if(sss != null && sss.length() < 5) {
            // Do something
        }
        if(sss != null & sss.length() < 5) { // it will produce NPE
            // Do something
        }


        boolean s1 = 5 == 5.0; // casts 5 to 5.0 and returns true as they are the primitives
        boolean s2 = false != "Giraffe"; // boolean and boolean; numerics with numerics; strings and strings etc
        // it also won`t work
        if (s1 = 4) {} // s1 = 4 return 4, and "if (4) {}" is a bad exp (u can write only bool in the if, no cast here)
        // Two references are equal if and only if they point to the same object, or both point to null.
    }
}
