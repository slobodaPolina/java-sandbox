package basics;

public class Chick {
    String string = "initialization step 1";
    // the name matches the name of the class + no return type given
    public Chick() { // note that public VOID basics.Chick() is NOT a constructor
        System.out.println("constructor");
        this.string = "initialization step 2";
    }
    public static void main(String[] args) {
        Chick chick = new Chick(); // it is ok cause we are in the static method
        chick.string = "initialization step 3";
    }
}