# ArrayList và LinkedList

## 1. ArrayList
- Là mảng động
- Truy xuất nhanh (O(1))
- Thêm/ xóa ở giữa và đầu chậm vì cần lùi tất cả phần từ phía sau ra 1 bước
- Tốn ít bộ nhớ hơn
- Ví dụ:
```java
// Thời gian thêm 1tr phần tử vào đầu danh sách và thời gian truy xuất 1tr phần tử trong ArrayList
public static void main(String[] args) {
    long startTime1 = System.currentTimeMillis();
    ArrayList<Integer> arr = new ArrayList<>();
    for(int i = 0; i < 1000000; i++) arr.addFirst(i);
    long endTime1 = System.currentTimeMillis();
    System.out.println("Thời gian add 1tr phần tử vào đầu ArrayList: " + (endTime1 - startTime1) + "ms");

    long startTime2 = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) arr.get(i);
    long endTime2 = System.currentTimeMillis();
    System.out.println("Thời gian truy xuất 1tr phần tử trong ArrayList: " + (endTime2 - startTime2) + "ms");
}
```
-> Kết quả:
```java
Thời gian add 1tr phần tử vào đầu ArrayList: 41288ms
Thời gian truy xuất 1tr phần tử trong ArrayList: 4ms
```
## 2. LinkedList
- Danh sách liên kết kép
- Truy xuất chậm (O(n)) vì phải đi từ đầu danh sách
- Thêm/xóa nhanh vì chỉ cần nối thêm node mới vào, không cần dịch chuyển node nào cả
- Tốn RAM hơn
- Ví dụ:
```java
// Thời gian thêm 1tr phần tử vào đầu danh sách và thời gian truy xuất 1tr phần tử trong LinkedList
public static void main(String[] args) {
    long startTime1 = System.currentTimeMillis();
    LinkedList<Integer> arr = new LinkedList<>();
    for(int i = 0; i < 1000000; i++) arr.addFirst(i);
    long endTime1 = System.currentTimeMillis();
    System.out.println("Thời gian add 1tr phần tử vào đầu LinkedList: " + (endTime1 - startTime1) + "ms");

    long startTime2 = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) arr.get(i);
    long endTime2 = System.currentTimeMillis();
    System.out.println("Thời gian truy xuất 1tr phần tử trong LinkedList: " + (endTime2 - startTime2) + "ms");
}
```
-> Kết quả:
```java
Thời gian add 1tr phần tử vào đầu LinkedList: 104ms
Thời gian truy xuất 1tr phần tử trong LinkedList: 669450ms
```