package lamda;

import java.util.function.*;

@FunctionalInterface
interface Greeting {
    String greet(String name);
}

public class index {
    public static void main(String[] args) {
        Greeting formal = name -> "Good morning, " + name + "!";
        Greeting casual = name -> "Hey " + name + "!";

        System.out.println(formal.greet("Alice"));
        System.out.println(casual.greet("Bob"));
    }
}