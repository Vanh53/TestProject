package collection.collections_hashmap_hashset;

import java.util.*;

//public class index {
//    public static void main(String[] args) {
//        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
//
//        // 1. Sắp xếp tăng dần (O(n log n))
//        Collections.sort(numbers);
//        System.out.println("Sort: " + numbers); // [1, 2, 5, 8, 9]
//
//        // 2. Đảo ngược danh sách
//        Collections.reverse(numbers);
//        System.out.println("Reverse: " + numbers); // [9, 8, 5, 2, 1]
//
//        // 3. Xáo trộn ngẫu nhiên (Rất hay dùng làm tính năng Random/Shuffle bài hát)
//        Collections.shuffle(numbers);
//        System.out.println("Shuffle: " + numbers); // Ví dụ: [5, 9, 1, 8, 2]
//
//        // 4. Tìm Max / Min
//        int max = Collections.max(numbers);
//        System.out.println("Max: " + max); // 9
//
//        // 5. Tìm kiếm nhị phân (Danh sách BẮT BUỘC PHẢI SẮP XẾP trước khi dùng)
//        Collections.sort(numbers);
//        int index = Collections.binarySearch(numbers, 5);
//        System.out.println("Vị trí số 5: " + index);
//    }
//}

//public class index {
//    public static void main(String[] args) {
//        // 1. HashMap: Lộn xộn
//        Map<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("Zalo", 1);
//        hashMap.put("Apple", 2);
//        hashMap.put("Mango", 3);
//        System.out.println("HashMap (Lộn xộn): " + hashMap);
//
//        // 2. LinkedHashMap: Đúng thứ tự chèn vào
//        Map<String, Integer> linkedMap = new LinkedHashMap<>();
//        linkedMap.put("Zalo", 1);
//        linkedMap.put("Apple", 2);
//        linkedMap.put("Mango", 3);
//        System.out.println("LinkedHashMap (Giữ thứ tự): " + linkedMap);
//
//        // 3. TreeMap: Tự động sắp xếp theo Alphabet của Key
//        Map<String, Integer> treeMap = new TreeMap<>();
//        treeMap.put("Zalo", 1);
//        treeMap.put("Apple", 2);
//        treeMap.put("Mango", 3);
//        System.out.println("TreeMap (Sắp xếp A-Z): " + treeMap);
//    }
//}


//public class index {
//    public static void main(String[] args) {
//        List<String> rawData = Arrays.asList("Java", "Python", "C++", "Java", "Go", "Python");
//
//        // 1. HashSet: Xóa trùng, in ra lộn xộn
//        Set<String> hashSet = new HashSet<>(rawData);
//        System.out.println("HashSet: " + hashSet);
//
//        // 2. LinkedHashSet: Xóa trùng, giữ đúng thứ tự xuất hiện lần đầu
//        Set<String> linkedSet = new LinkedHashSet<>(rawData);
//        System.out.println("LinkedHashSet: " + linkedSet);
//
//        // 3. TreeSet: Xóa trùng, sắp xếp theo Alphabet
//        Set<String> treeSet = new TreeSet<>(rawData);
//        System.out.println("TreeSet: " + treeSet);
//    }
//}


//public class index {
//    public static void main(String[] args) {
//        int elements = 1000000;
//
//        Map<Integer, String> hashMap = new HashMap<>();
//        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
//        Map<Integer, String> treeMap = new TreeMap<>();
//
//        System.out.println("--- 1. THỜI GIAN THÊM 1 TRIỆU PHẦN TỬ ---");
//
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < elements; i++) hashMap.put(i, "User" + i);
//        System.out.println("HashMap:       " + (System.currentTimeMillis() - start) + " ms");
//
//        start = System.currentTimeMillis();
//        for (int i = 0; i < elements; i++) linkedHashMap.put(i, "User" + i);
//        System.out.println("LinkedHashMap: " + (System.currentTimeMillis() - start) + " ms");
//
//        start = System.currentTimeMillis();
//        for (int i = 0; i < elements; i++) treeMap.put(i, "User" + i);
//        System.out.println("TreeMap:       " + (System.currentTimeMillis() - start) + " ms");
//
//        System.out.println("\n--- 2. THỜI GIAN TÌM KIẾM 1 PHẦN TỬ ---");
//        int targetKey = 500000;
//
//        start = System.currentTimeMillis(); // Dùng nanoTime vì tốc độ tìm kiếm cực nhanh
//        for(int i = 0; i < 1000000; i++) hashMap.get(targetKey);
//        System.out.println("HashMap:       " + (System.currentTimeMillis() - start) + " ms");
//
//        start = System.currentTimeMillis();
//        for(int i = 0; i < 1000000; i++) linkedHashMap.get(targetKey);
//        System.out.println("LinkedHashMap: " + (System.currentTimeMillis() - start) + " ms");
//
//        start = System.currentTimeMillis();
//        for(int i = 0; i < 1000000; i++) treeMap.get(targetKey);
//        System.out.println("TreeMap:       " + (System.currentTimeMillis() - start) + " ms");
//    }
//}

public class index {
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
}