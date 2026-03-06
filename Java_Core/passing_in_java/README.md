## Passing Mechanism (Truyền tham số) trong java
*Java luôn truyền bằng giá trị*
1. Passing by Value
- Dùng với các kiểu dữ liệu nguyên thủy (int, double, boolen, ...), giá trị sẽ được sao chép vào stack memory, sau đó được truyền vào phương thức được gọi
- Khi thay đổi giá trị của biến trong phương thức, giá trị của biến tương ứng bên ngoài sẽ không bị thay đổi
- Ví dụ:
```java
public class index {
    public static void main(String[] args) {
        int a = 20;
        System.out.println("Gia tri luc truoc: " + a);
        passingByValue(a);
        System.out.println("Gia tri luc sau: " + a);
    }
    public static void passingByValue(int a) {
        a = 30;
        System.out.println("Gia tri trong ham: " + a);
    }
}
```
-> Kết quả:
```java
Gia tri luc truoc: 20
Gia tri trong ham: 30
Gia tri luc sau: 20
```
2. Pssing by Reference
- Dữ liệu không phải nguyên thủy (string, stringBuilder, array, class, ...) có tham chiếu lưu trong stack memory, trỏ tới dữ liệu thực tế trong heap memory, khi biến này đuợc 
truyền vào phương thức, giá trị tham chiếu sẽ được sao chép và truyền vào phương thức
- Khi thay đổi giá trị của biến trong phương thức, biến truyền giá trị tham chiếu tương ứng bên ngoài cũng bị thay đổi
- Ví dụ:
```java
public class index {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) arr[i] = i;
        System.out.print("Gia tri luc truoc:" );
        for(int i = 0; i < 5; i++) System.out.print(arr[i] + " ");
        System.out.println("");
        passingByReference(arr);
        System.out.print("Gia tri luc sau: ");
        for(int i = 0; i < 5; i++) System.out.print(arr[i] + " ");
    }
    public static void passingByReference(int[] arr) {
        for(int i = 0; i < 5; i++) arr[i] = 5 - i;
    }
}
```
-> Kết quả:
```java
Gia tri luc truoc:0 1 2 3 4 
Gia tri luc sau: 5 4 3 2 1 
```