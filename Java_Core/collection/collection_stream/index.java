package collection.collection_stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class index {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 4, 3, 7, 8, 5, 9, 3,6, 8, 4,5, 2, 7);
        List<String> list2 = Arrays.asList("An", "Binh", "Cong", "Dung");

        long sum = list1.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        long max = list1.stream()
                .reduce((a, b) -> a >= b ? a : b)
                .orElse(0);
        System.out.println(max);
    }
}