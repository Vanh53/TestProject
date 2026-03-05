package string.string_pool;

public class index {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println("----");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println("----");
        String d = c.intern();
        System.out.println(a == d);
    }
}