## Generic 
***Tham số hóa, làm cho kiểu dữ liệu trở nên tổng quát***
1. **Generic class**
- Cú pháp: class TenClass <Danh sách kiểu dữ liệu tổng quát> {}
- Ví dụ:
```java
class Pair<T, E> {
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
```
-> Kết quả:
```java
Day la Pair 1
```
2. **Generic method**
- Cú pháp: <T> (kiểu dữ liệu trả về) (tên hàm) (danh sách tham số) {}
- Ví dụ:
```java
public class index {
    public static void main(String[] args) {
        printTest("20");
        printTest(22);
    }
    public static <T> void printTest(T age) {
        System.out.println("Day la so " + age);
    }
}
```
-> Kết quả:
```java
Day la so 20
Day la so 22
```
3. **Generic interface**

Ví dụ:

```java
interface Repository<T> {
    void save(T t);
    T findById(int id);
}
class CarRepository implements Repository<Car> {
    @Override
    public void save(Car car) { System.out.println("Lưu xe: " + car.getName()); }
    @Override
    public Car findById(int id) { return new Car("Jaguar", "V8"); }
}
```
4. **Wildcards và Bounded Generics**

***Giới hạn kiểu dữ liệu mà tham số tổng quát có thể nhận***

- Upper Bounded Wildcard (? extends T): chấp nhận kiểu dữ liệu T hoặc các kiểu con của T

    - Ví dụ:
```java
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
```
-> Integer là lớp con của Number nên được chấp nhận

    - Ví dụ 2:
```java
public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>("1", "Pair 1");
        System.out.println("Day la " + pair.second);
    }
```
-> Lỗi

    - Các lớp cha con:
        - Number và các lớp con Integer, Double, Float, Long, Short, Byte, BigInteger & BigDecimal
        - Collection và các lớp con List (ArrayList, LinkedList), Set (HashSet, TreeSet)
- Lower Bounded Wildcard (? super T): chấp nhận kiểu dữ liệu T hoặc các kiểu cha của T
    - Ví dụ:
```java
List<? super Integer>
```
- Unbounded Wildcard: Chấp nhận mọi kiểu dữ liệu