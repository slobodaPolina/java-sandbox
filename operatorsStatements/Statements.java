package operatorsStatements;

public class Statements {
    // Control flow statements
    // if, if-else statements (easy)

    public int switchMethod(int param, final int parameter2) {

        // values that could be promoted to int, specifically byte, short, char, or int + their wrapper classes (Byte, Short, Character, or Integer) + enums + Strings
        // Note that boolean and long, and their associated wrapper classes, are NOT supported by switch statements!

        int variable = 4;
        final int finalVar = 8;
        switch(2 + 4) {
            case 1: // must be compile-time CONSTANT values of the SAME DATA TYPE as the switch value above
                // This means you can use only literals, enum constants, or FINAL CONSTANT VARIABLES of the same data type
                System.out.println("1");
                break; // if you leave out the break statement, flow will continue execution automatically until it finds "break" statement
            default: // execute it if no suitable case-blocks found (or it can be executed if case-block above omit breaks)
                System.out.println("??"); // AHTUNG! it will execute this block and ALL THE BLOCKS BELOW until it finds "break" statement
            case 9: //case or default statements can be in any order
                System.out.print("d");
            case 9 + 4: // it is constant actually (no variety here)
                System.out.print("dz");
            case param:
                System.out.print("oh no! not a constant");
            case "34":
                System.out.print("oh no! not the same type");
            case variable:
                System.out.print("oh no! not FINAL (actually we do exactly know the value, but it has to be FINAL");
                break;
            case finalVar:
                System.out.print("fine - it is final, good type, and constant - we hard-coded the exact value");
            case parameter2:
                System.out.print("even final, good type, but not a constant");
        }
        // "case" is a point to enter, "break" is the only way out
        return finalVar;
    }

    public loopMethod() {
        // while
        // do-while
        int x = 0;
        do {
            x++;
        } while(false);
        System.out.println(x); // x=1 (do-while executes at lest once)

        for( ; ; ) { //an infinite loop
            System.out.println("Hello World");
        }

        for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) { // we can use multiple loop variables
            System.out.print(y + " ");
        }
        System.out.print(x);

        for(x = 0; x < 7; x++) {} //u can use the vars outside the loop as loop variables (not to create more ones)
        for(int x = 0; x < 7; x++) {} // and here it throws an exception cause u recreate x (it is already defined)
        for (int v1 = 2, long v2 = 3L; v1 < 10; v1++) {} // oh here the same rool as in simple declaration statements - u can declare several vars of ONE type

        // for-each loop, enhanced for loop:
        // array or class implements java.lang.Iterable
        String[] names = {"Lisa", "Kevin"}; // make sure it is list\array
        for(String name : names) { // make sure the elem in the array\list has suitable type
            System.out.print(name + ", ");
        }

        //optional label
        loooooooop: for(String name : names) {
            System.out.print(name + ", ");
            break loooooooop;// finish the execution of the cycle
            x = 4; // it was a break before but the compiler doesnt care
            continue loooooooop; // ends the current iteration of the loop (not all the iterations as 'break' does)
        }

        label: if (true) {// Labels are allowed for any block statement
            // smth
            break;
            continue;
            break label; // strange)
            continue label;
        }
    }
}
