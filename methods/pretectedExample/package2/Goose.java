package methods.pretectedExample.package2;

import methods.pretectedExample.package1.Bird;

/* content of the Bird class:

public class Bird {
    protected void swim() { }
}

 */

public class Goose extends Bird {
    {
        swim(); // ok - we call it from extended class Goose (it is the same as "this.swim()")

        Goose goose = new Goose();
        goose.swim(); // ok - we call it from "goose" which is extended

        Bird bird = new Goose();
        bird.swim(); //  oh no! bird is the Bird object and Bird does not extend the Bird!
        // So as the object does not extend that class and the package is not the same we does not have access.
        // and of course it will not work either:
        Bird bird1 = new Bird();
        bird1.swim();
    }
}

class Duck {
    {
        // pay attention in addition to this we have to be inside that class which is extended
        Goose goose = new Goose();
        goose.swim();
    }

    // sum all the things up- u can call the protected method ... :
    // 1 - from own package
    // 2 - call using EXTENDED class variable using the code located in same EXTENDED class
}