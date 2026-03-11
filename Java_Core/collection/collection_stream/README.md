## Collection stream
1. filter() 
- Dùng để lọc phần tử, giữ lại các phần tử thỏa điều kiện
- Trả về stream mới
- Ví dụ: lọc số chẵn
```java
public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 4, 3, 7, 8, 5, 9, 3,6, 8, 4,5, 2, 7);
    List<String> list2 = Arrays.asList("An", "Binh", "Cong", "Dung");

    List<Integer> even = list1.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
    for (int i: even) {
        System.out.print(i + " ");
    }
}
```
-> Kết quả:
```java
2 4 4 8 6 8 4 2 
```
2. map()
- Dùng để áp dụng một hàm lên mỗi phần tử
- Trả về stream kết quả
- Ví dụ:
```java
List<String> map = list2.stream()
        .map(n -> n + "1")
        .collect(Collectors.toList());
for (String i: map) {
    System.out.print(i + " ");
}
```
-> Kết quả:
```java
An1 Binh1 Cong1 Dung1 
```
3. reduce()
- Gộp về một giá trị, gom stream thành một giá trị duy nhất (tổng, tích, max, min, nối chuỗi, ...)
- reduce(giá_trị_khởi_tạo, (kết_quả_tích_lũy, phần_tử_hiện_tại) -> phép_toán_gộp)
- Ví dụ: 
```java
// Tính tổng
long sum = list1.stream()
        .reduce(0, (a, b) -> a + b);
```
```java
// Tính max
long max = list1.stream()
        .reduce((a, b) -> a >= b ? a : b)
        .orElse(0);
System.out.println(max);
```
4. collect()
- Gom kết quả
- Ví dụ: 
```java
.collect(Collectors.toList());
```
5. sorted() 
- Sắp xếp (mặc định tăng dần)
- Sắp xếp giảm dần: 
```java
.sorted(Comparator.comparingInt(String::length).reversed())
```
6. distinct()
- Loại bỏ trùng lặp
7. anyMatch(), allMatch(), noneMatch()
- Ví dụ:
```java
boolean any = list1.stream().anyMatch(n -> n > 9);
boolean all = list1.stream().allMatch(n -> n >= 1);
boolean none = list1.stream().noneMatch(n -> n > 9);
```
-> Kết quả:
```java
false
true
true
```
8. forEach()
- Duyệt phần tử
- Ví dụ:
```java
.forEach(System.out::println);
```
9. limit(n): giới hạn n phần tử
10. skip(n): bỏ qua n phần tử đầu
11. count(): đếm phần tử