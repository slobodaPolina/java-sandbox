package basics;

public class Initializer {
    { //instance initializer
        System.out.println("1");
        System.out.println(name);
        name = "meaw!"; // hmm but why it is ok here?
        System.out.println(name);
    }

    private String name = "2"; // Fields and instance initializer blocks are run in the order in which they appear in the file

    { //instance initializer
        System.out.println("3");
    }

    public Initializer() { //The constructor runs after all fields and instance initializer blocks have run.
        name = "Tiny";
        System.out.println("5");
    }

    public static void main(String[] args) {
        System.out.println("0"); // entrance
        Initializer ini = new Initializer(); // creating an instance - fields&instance initializers, then goes constructor
        System.out.println("6");
        {
            System.out.println("7");
        }
    }

    { //instance initializer
        System.out.println("4");
    }
}
