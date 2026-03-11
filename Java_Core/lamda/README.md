# Lamda in java
## 1. Lamda
- Là một hàm ẩn danh
- Được định nghĩa inline
- Có thể được truyền như một giá trị
## 2. Các dạng cú pháp
- Dạng 1: Không tham số
```java
() -> System.out.println("Hello")
```
- Dạng 2: Một tham số
```java
(x) -> x * x
```
- Dạng 3: Nhiều tham số
```java
(x, y) -> x + y
```
- Dạng 4: Khai báo kiểu tường minh
```java
(int x, int y) -> x + y
```
- Dạng 5: Block body (Nhiều câu lệnh, cần return)
```java
(x, y) -> {
    int sum = x + y;
    return sum;
}
```
- Dạng 6: Trả về void với block body
```java
(String s) -> {
    System.out.println("Name: " + s);
    System.out.println("Length: " + s.length());
}
```
## 3. Funtional Interface
## 4. Các funtional interface có sẵn
### 4.1 Runnable 
- Không nhận, không trả về
- Phương thức: run()
- Ví dụ:
```java
public static void main(String[] args) {
    Runnable task = () -> {
        System.out.println("Hello world 1");
        System.out.println("Hello world 2");
    };
    task.run();
}
```
-> Kết quả:
```java
Hello world 1
Hello world 2
```
### 4.2 Supplier<T> 
- Không nhận, trả về T
- Phương thức: get()
- Ví dụ:
```java
public static void main(String[] args) {
    Supplier<Double> random = () -> Math.random();
    System.out.println("Random value: " + random.get());
}
```
-> Kết quả:
```java
Random value: 0.43093042298812567
```
### 4.3 Consumer<T> 
- Nhận T, không trả về
- Phương thức: accpet(T)
- Ví dụ:
```java
public static void main(String[] args) {
    Consumer<String> cons = (name) -> System.out.println("Hello " + name);
    cons.accept("Vanh");
}
```
-> Kết quả:
```java
Hello Vanh
```
### 4.4 Funtion<T, R> 
- Nhận T, trả về R
- Phương thức: apply(T)
- Ví dụ:
```java
public static void main(String[] args) {
    Function<String, Integer> func = (name) -> name.length();
    System.out.println("Length: " + func.apply("Vanh"));
}
```
-> Kết quả:
```java
Length: 4
```
### 4.5 Predicate<T> 
- Nhận T, trả về boolean
- Phương thức: test(T)
- Ví dụ:
```java
public static void main(String[] args) {
    Predicate<Integer> func = (age) -> age > 18;
    System.out.println("Age > 18??: " + func.test(22));
}
```
-> Kết quả:
```java
Age > 18??: true
```
### 4.6 BiFuntion<T, U, R> 
- Nhận T và U, trả về R
- Phương thức: apply(T, U)
- Ví dụ:
```java
public static void main(String[] args) {
    BiFunction<Integer, Integer, Integer> func = (a, b) -> a + b;
    System.out.println("Sum A + B: " + func.apply(10, 20));
}
```
-> Kết quả:
```java
Sum A + B: 30
```
### 4.7 UnaryOperator<T> và BinaryOperator<T>
- UnaryOperator<T> là trường hợp đặc biệt của Function<T, R> khi kiểu đầu vào và đầu ra giống nhau (T → T)
- BinaryOperator<T> là trường hợp đặc biệt của BiFunction<T, U, R> khi cả 3 kiểu đều giống nhau (T, T → T)

## 5. Method Reference (Tham chiếu phương thức)
- Method Reference là cách viết ngắn gọn hơn của lambda khi lambda chỉ gọi một method có sẵn.
### 5.1 Dạng 1
- Static method reference
- Lambda: x -> ClassName.staticMethod(x)
- Ref: ClassName::staticMethod
- Ví dụ:
```java
Function<String, Integer> parse = Integer::parseInt;
System.out.println(parse.apply("42"));
```
### 5.2 Dạng 2
- Instance method của object cụ thể
- Lambda: x -> obj.method(x)
- Ref: obj::method
- Ví dụ:
```java
String prefix = "Hello, ";
Function<String, String> greet = prefix::concat;
System.out.println(greet.apply("World"));
```
### 5.3 Dạng 3
- Instance method của kiểu tổng quát
- Lambda: x -> x.method()
- Ref: ClassName::method
- Ví dụ:
```java
Function<String, String> upper = String::toUpperCase;
System.out.println(upper.apply("java"));
```
### 5.4 Dạng 4
- Constructor reference
- Lambda: x -> new ClassName(x)
- Ref: ClassName::new
- Ví dụ:
```java
Function<String, StringBuilder> sbFactory = StringBuilder::new;
StringBuilder sb = sbFactory.apply("Hello");
System.out.println(sb);
```