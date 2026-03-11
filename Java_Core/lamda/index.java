package lamda;

import java.util.function.*;

public class index {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> func = (a, b) -> a + b;
        System.out.println("Sum A + B: " + func.apply(10, 20));
    }
}