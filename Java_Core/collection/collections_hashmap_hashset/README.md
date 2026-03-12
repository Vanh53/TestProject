# Collections, Map, Set
## 1. Collections
- Là một lớp tiện ích chứa các hàm static, cung cấp các thao tác trên các Collection có sẵn (List, Set)
- Ví dụ về các hàm hay dùng:
```java
public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));

    // 1. Sắp xếp tăng dần (O(n log n))
    Collections.sort(numbers);
    System.out.println("Sort: " + numbers); // [1, 2, 5, 8, 9]

    // 2. Đảo ngược danh sách
    Collections.reverse(numbers);
    System.out.println("Reverse: " + numbers); // [9, 8, 5, 2, 1]

    // 3. Xáo trộn ngẫu nhiên (Rất hay dùng làm tính năng Random/Shuffle bài hát)
    Collections.shuffle(numbers);
    System.out.println("Shuffle: " + numbers); // Ví dụ: [5, 9, 1, 8, 2]

    // 4. Tìm Max / Min
    int max = Collections.max(numbers);
    System.out.println("Max: " + max); // 9

    // 5. Tìm kiếm nhị phân (Danh sách BẮT BUỘC PHẢI SẮP XẾP trước khi dùng)
    Collections.sort(numbers);
    int index = Collections.binarySearch(numbers, 5);
    System.out.println("Vị trí số 5: " + index);
}
```
## 2. Map
- Lưu dữ liệu dạng cặp key-value, key là duy nhất
- HashMap:
  - Bảng băm (Hash Table)
  - Tốc độ cực nhanh O(1), cho phép 1 Key là null
  - Thứ tự lưu lộn xộn
- LinkedHashMap:
  - Bảng băm + Danh sách liên kết kép
  - Giữ nguyên thứ tự chèn gốc, tốc độ gần bằng HashMap
  - Tốn nhiều RAM
- TreeMap:
  - Cây đỏ đen (Red-Black Tree)
  - Tự động sắp xếp các phần tử tăng dần theo Key
  - Tốc độ chậm hơn và không cho phép key null
- Ví dụ:
```java
public static void main(String[] args) {
    // 1. HashMap: Lộn xộn
    Map<String, Integer> hashMap = new HashMap<>();
    hashMap.put("Zalo", 1);
    hashMap.put("Apple", 2);
    hashMap.put("Mango", 3);
    System.out.println("HashMap (Lộn xộn): " + hashMap);

    // 2. LinkedHashMap: Đúng thứ tự chèn vào
    Map<String, Integer> linkedMap = new LinkedHashMap<>();
    linkedMap.put("Zalo", 1);
    linkedMap.put("Apple", 2);
    linkedMap.put("Mango", 3);
    System.out.println("LinkedHashMap (Giữ thứ tự): " + linkedMap);

    // 3. TreeMap: Tự động sắp xếp theo Alphabet của Key
    Map<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("Zalo", 1);
    treeMap.put("Apple", 2);
    treeMap.put("Mango", 3);
    System.out.println("TreeMap (Sắp xếp A-Z): " + treeMap);
}
```
-> Kết quả:
```java
HashMap (Lộn xộn): {Zalo=1, Apple=2, Mango=3}
LinkedHashMap (Giữ thứ tự): {Zalo=1, Apple=2, Mango=3}
TreeMap (Sắp xếp A-Z): {Apple=2, Mango=3, Zalo=1}
```
```java
// Ví dụ thời gian thêm/tìm 1tr phần tử
public static void main(String[] args) {
    int elements = 1000000;

    Map<Integer, String> hashMap = new HashMap<>();
    Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
    Map<Integer, String> treeMap = new TreeMap<>();

    System.out.println("--- 1. THỜI GIAN THÊM 1 TRIỆU PHẦN TỬ ---");

    long start = System.currentTimeMillis();
    for (int i = 0; i < elements; i++) hashMap.put(i, "User" + i);
    System.out.println("HashMap:       " + (System.currentTimeMillis() - start) + " ms");

    start = System.currentTimeMillis();
    for (int i = 0; i < elements; i++) linkedHashMap.put(i, "User" + i);
    System.out.println("LinkedHashMap: " + (System.currentTimeMillis() - start) + " ms");

    start = System.currentTimeMillis();
    for (int i = 0; i < elements; i++) treeMap.put(i, "User" + i);
    System.out.println("TreeMap:       " + (System.currentTimeMillis() - start) + " ms");

    System.out.println("\n--- 2. THỜI GIAN TÌM KIẾM 1 PHẦN TỬ ---");
    int targetKey = 500000;

    start = System.currentTimeMillis(); // Dùng nanoTime vì tốc độ tìm kiếm cực nhanh
    for(int i = 0; i < 1000000; i++) hashMap.get(targetKey);
    System.out.println("HashMap:       " + (System.currentTimeMillis() - start) + " ms");

    start = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) linkedHashMap.get(targetKey);
    System.out.println("LinkedHashMap: " + (System.currentTimeMillis() - start) + " ms");

    start = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) treeMap.get(targetKey);
    System.out.println("TreeMap:       " + (System.currentTimeMillis() - start) + " ms");
}
```
-> Kết quả:
```java
--- 1. THỜI GIAN THÊM 1 TRIỆU PHẦN TỬ ---
HashMap:       124 ms
LinkedHashMap: 123 ms
TreeMap:       176 ms

--- 2. THỜI GIAN TÌM KIẾM 1 PHẦN TỬ ---
HashMap:       13 ms
LinkedHashMap: 12 ms
TreeMap:       32 ms
```
## 3. Set
- Lưu các giá trị không trùng lặp
- HashSet:
  - Không trùng lặp + Lộn xộn
  - Hiệu năng thêm/xóa/tìm kiếm tốt nhất O(1)
- LinkedHashSet:
  - Không trùng lặp + Giữ thứ tự chèn
  - Tốn RAM
- TreeSet:
  - Không trùng lặp + Tự động sắp xếp
  - Thêm/xóa chậm hơn
- Ví dụ:
```java
// Ví dụ về thứ tự chèn
public static void main(String[] args) {
    List<String> rawData = Arrays.asList("Java", "Python", "C++", "Java", "Go", "Python");

    // 1. HashSet: Xóa trùng, in ra lộn xộn
    Set<String> hashSet = new HashSet<>(rawData);
    System.out.println("HashSet: " + hashSet);

    // 2. LinkedHashSet: Xóa trùng, giữ đúng thứ tự xuất hiện lần đầu
    Set<String> linkedSet = new LinkedHashSet<>(rawData);
    System.out.println("LinkedHashSet: " + linkedSet);

    // 3. TreeSet: Xóa trùng, sắp xếp theo Alphabet
    Set<String> treeSet = new TreeSet<>(rawData);
    System.out.println("TreeSet: " + treeSet);
}
```
-> Kết quả:
```java
HashSet: [Java, C++, Go, Python]
LinkedHashSet: [Java, Python, C++, Go]
TreeSet: [C++, Go, Java, Python]
```
```java
// Ví dụ so sánh thời gian thêm và kiểm tra constain 1tr phần tử
public static void main(String[] args) {
    int elements = 1000000;

    Set<Integer> hashSet = new HashSet<>();
    Set<Integer> linkedHashSet = new LinkedHashSet<>();
    Set<Integer> treeSet = new TreeSet<>();

    System.out.println("--- 1. THỜI GIAN THÊM 1 TRIỆU PHẦN TỬ  ---");

    long start = System.currentTimeMillis();
    for (int i = 0; i < elements; i++) hashSet.add(i);
    System.out.println("HashSet:       " + (System.currentTimeMillis() - start) + " ms");

    start = System.currentTimeMillis();
    for (int i = 0; i < elements; i++) linkedHashSet.add(i);
    System.out.println("LinkedHashSet: " + (System.currentTimeMillis() - start) + " ms");

    start = System.currentTimeMillis();
    for (int i = 0; i < elements; i++) treeSet.add(i);
    System.out.println("TreeSet:       " + (System.currentTimeMillis() - start) + " ms");

    System.out.println("\n--- 2. THỜI GIAN KIỂM TRA TỒN TẠI 1tr LẦN ---");
    int targetValue = 500000;

    start = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) hashSet.contains(targetValue);
    System.out.println("HashSet:       " + (System.currentTimeMillis() - start) + " ms");

    start = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) linkedHashSet.contains(targetValue);
    System.out.println("LinkedHashSet: " + (System.currentTimeMillis() - start) + " ms");

    start = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) treeSet.contains(targetValue);
    System.out.println("TreeSet:       " + (System.currentTimeMillis() - start) + " ms");
}
```
-> Kết quả:
```java
--- 1. THỜI GIAN THÊM 1 TRIỆU PHẦN TỬ  ---
HashSet:       62 ms
LinkedHashSet: 87 ms
TreeSet:       123 ms

--- 2. THỜI GIAN KIỂM TRA TỒN TẠI 1tr LẦN ---
HashSet:       11 ms
LinkedHashSet: 12 ms
TreeSet:       34 ms
```
