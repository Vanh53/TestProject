1. String pool là vùng nhớ nằm trong heap memory, dùng để chứa String
2. Khi tạo String bằng "" thì JVM sẽ tìm trong String pool, nếu có đã thì trả về địa chỉ của String có sẵn trong 
String pool, còn chưa có thì sẽ tạo mới
3. Khi tạo String bằng new, thì JVM sẽ tạo đối tượng String mới trong Heap memory (nằm ngoài String pool), mỗi lần new là mỗi cấp phát một địa chỉ mới
4. hàm intern() dùng để thêm chuỗi vào String pool
-> Cơ chế: kiểm tra trong pool, nếu đã tồn tại -> trả về địa chỉ, nếu chưa tồn tại -> tạo mới trong pool và trả về địa chỉ mới
<br>
-> Việc dùng string pool sẽ tiết kiệm bộ nhớ hơn
5. Ví dụ:
- ### String Literal và String Object
    ``` java
    String a = "Hello";
    String b = "Hello";
    String c = new String("Hello");
    
    System.out.println(a.equals(b));
    System.out.println(a.equals(c));
    System.out.println("----");
    System.out.println(a == b);
    System.out.println(a == c);
    System.out.println("----");
   ```
-> Kết quả:

    true
    true
    ----
    true
    false

-> Giải thích: a và b cùng được tạo từ "" nên cùng là 1 đối tượng (cùng địa chỉ) trong string pool, 
c có cùng giá trị với a và b nhưng được lưu ở ngoài string pool
<br>
Dùng equals sẽ so sánh giá trị nên trả về 2 giá trị true, dùng == sẽ so sánh địa chỉ, địa chỉ a và b giống nhau sẽ trả về true, 
địa chỉ a và c khác nhau nên trả về false

- ### Dùng intern():
    ```java
    String d = c.intern();
    System.out.println(a == d);
  ```

-> Kết quả: 
  ```java
  true
  ```

-> Giải thích: hàm intern() sẽ đưa string vào string pool và trả về địa chỉ cho d