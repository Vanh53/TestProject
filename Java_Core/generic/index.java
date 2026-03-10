package generic;

class Pair<T extends Number, E> {
    public T first;
    public E second;

    public Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }
}

public class index {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(1, "Pair 1");
        System.out.println("Day la " + pair.second);
    }
}