package basics;

public class HelloWorld {
    private static int $;
    private static Integer _1h; // start with $, _ or letter. Contains $, _, letters and numbers. And no reserved words!

    public static void main(String[] main) {
        System.out.print(_1h + $); // $ is 0 and the _1h is null so we will get NPE when execute it (null + 0)
        String a_b;
        int какНиСтранно_ЭтоТожеВалидноеИме$к0;
        System.out.print(a_b + какНиСтранно_ЭтоТожеВалидноеИме$к0); // non-locals are ok cause initialized by default. here local vars are not initialied

        // -------------------------------------------------
        String s1 = "Java";
        String s2 = "Java";
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Ja").append("va");
        System.out.println(s1 == s2); // true cause they are the same (initialized as same constant strings)
        System.out.println(s1.equals(s2)); // ofc true
        System.out.println(sb1.toString() == s1); // false cause sb1.toString() is not the constant "Java" => not same obj
        System.out.println(sb1.toString().equals(s1)); // ofc true

        Long a = 127L; Long b = 127L; // initialize it as 127 (u cant use it without L)
        System.out.println(a == b); // true cause as with the strings in previous example they are the same obj
        a = 128L; b = 128L;
        System.out.println(a == b); // false cause they now exceeded the limit, u can use that trick inside [-128L; 127L]

        Integer z = -128; Integer x = -128;
        System.out.println(z == x); // true cause it is the same trick with Integer, Short and Byte [-128; 127]
    }
}