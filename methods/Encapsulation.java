package methods;

public class Encapsulation {
    // Encapsulation means we set up the class so only methods
    //in the class with the variables can refer to the instance variables.

    private int numberEggs; // so it is to make fields private to control them
    public int getNumberEggs() { //accessor method
        return numberEggs;
    }
    public void setNumberEggs(int numberEggs) { //mutator method
        if (numberEggs >= 0)
            this.numberEggs = numberEggs;
    }

    // JavaBeans naming conventions:
    // Properties are private.
    // Getter methods begin with is if the property is a boolean. (for example if variable is "happy", getter will be "isHappy"). Otherwise begin with "get"
    // Setters begin with "set"
}

// to prevent uncontrollable changes of the properties we can prevent it at all and make class immutable
class NotImmutable {
    private StringBuilder builder;
    public NotImmutable(StringBuilder b) {
        builder = b;
    }
    public StringBuilder getBuilder() {
        return builder;
    }
    // not immutable because of the references
}

class Tester {
    {
        StringBuilder sb = new StringBuilder("initial");
        NotImmutable problem = new NotImmutable(sb);
        sb.append(" added"); // we can rule it using sb (initial param passed to controller - it is still one object!)
        StringBuilder gotBuilder = problem.getBuilder();
        gotBuilder.append(" more"); // and we can rule it by getting reference
        // actually we cannot set "builder" to another class, but we can change it
    }
}

class Immutable {
    private StringBuilder builder;
    public Immutable(StringBuilder b) {
        builder = new StringBuilder(b); // making a copy
    }
    public StringBuilder getBuilder() {
        return new StringBuilder(builder); // returning a copy
    }
    // so nobody can change the real "builder" after it has been set
}