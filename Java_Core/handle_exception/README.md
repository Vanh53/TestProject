## Xử lý ngoại lệ
1. **try-catch**
- Dùng try để bọc đoạn code có rủi ro và catch để xử lý ngoại lệ khi xảy ra
- Ví dụ:
```java
public static void kiemTraTuoi(int tuoi) {
    try {
        int a = 10 / 0;
    } catch (Exception e) {
        System.out.println("Lỗi: " + e.getMessage());
    }
}
```
-> Kết quả:
```java
Lỗi: / by zero
```
2. **finally**
- Khối luôn luôn được thực thi bất kể ngoại lệ có xảy ra hay không
- Thường dùng để giải phóng tài nguyên
- Ví dụ:
```java
public static void kiemTraTuoi(int tuoi) {
    try {
        int a = 10 / 0;
    } catch (Exception e) {
        System.out.println("Lỗi: " + e.getMessage());
    } finally {
        System.out.println("Đã thực hiện xong!");
    }
}
```
-> Kết quả:
```java
Lỗi: / by zero
Đã thực hiện xong!
```
3. **try-with-resources**
- Tự động đóng các tài nguyên mà không cần viết khối finally
- Truyền vào ngoặc tròn các đối tượng AutoCloseable
- Ví dụ:
```java
public static void main(String[] args) {
    try (Scanner sc = new Scanner(new File("test.txt"))) {
        int a = sc.nextInt();
    } catch (Exception e) {
        System.out.println("Lỗi: " + e.getMessage());
    }
}
```
-> Scanner sẽ được tự động đóng 
4. **multiple catch block**
- Xử dụng nhiều khối catch để bắt nhiều lỗi liên tiếp
- Quy tắc: Bắt các lỗi cụ thể trước rồi mới đến các lỗi chung chung
- Ví dụ:
```java
try (Scanner sc = new Scanner(new File("test.txt"))) {
    int a = sc.nextInt();
} catch (FileNotFoundException e) {
    System.out.println("Lỗi: " + e.getMessage());
} catch (IOException e) {
    System.out.println("Lỗi: " + e.getMessage());
}
```
5. **union catch block**
- Xử dụng toán tử | để gộp các lỗi có chung các xử lý thành một catch duy nhất
- Ví dụ:
```java
try (Scanner sc = new Scanner(new File("test.txt"))) {
    int a = sc.nextInt();
} catch (IllegalArgumentException | IOException e) {
    System.out.println("Lỗi: " + e.getMessage());
}
```
6. **throw**
- Nằm bên trong thân hàm
- Tạo và chủ động ném ra ngoại lệ
- Dùng khi muốn custom exception, ...
- Ví dụ:
```java
public List<Player> loadAllPlayers(String playersFile) {
    if(!isFilenameValid(playersFile)) {
        // Chủ động tạo và ném ra một lỗi ngay lập tức
        throw new IllegalArgumentException("Filename isn't valid!"); 
    }
}
```
7. **throws**
- Khai báo ở chữ ký hàm (cạnh tên hàm và danh sách tham số)
- Đẩy ngoại lệ cho nơi gọi hàm đó xử lý
- Ví dụ:
```java
public static void docFile() throws IOException {
    Scanner sc = new Scanner(new File("test.txt"));
    int a = sc.nextInt();
    System.out.println("Doc file thanh cong!");
}
```
8. **wrapping and rethrowing**
- Rethrowing: Bắt lỗi ở mức thấp và ném ra một lỗi ở mức cao hơn
- Ví dụ:
```java
public List<Player> loadAllPlayers(String playersFile) throws IOException {
    try { 
        // ... đọc file
    } catch (IOException io) { 		
        throw io; // Ném lại chính lỗi io gốc
    }
}
```
- Wrapping: bọc lỗi cũ vào lỗi mới, phải truyền lỗi cũ vào constructor của lỗi mới để có thể truy vết
- Ví dụ:
```java
public List<Player> loadAllPlayers(String playersFile) throws PlayerLoadException {
    try { 
        // ... đọc file
    } catch (IOException io) { 		
        // Tạo lỗi mới, NHƯNG phải nhét lỗi cũ (io) vào constructor
        throw new PlayerLoadException(io); 
    }
}
```
9. **Phân loại các ngoại lệ**
- Checkde Exception:
  - Lỗi liên quan đến yếu tố bên ngoài (network, file, database)
  - Trình biên dịch phải xử lý
  - Ví dụ: IOException, FileNotFoundException, SQLException, ...
- Unchecked Exception:
  - Lỗi do lập trình sai sót
  - Các lỗi phổ biến: NullPointerException (gọi object null), IllegalArgumentException (tham số sai), 
ArrayIndexOutOfBoundsException (truy cập quá giới hạn mảng), ClassCastException (ép kiểu sai), 
NumberFormatException (parse chữ thành số thất bại), ...
- Errors: Lỗi hệ thống máy ảo nghiêm trọng (StackOverflowError, OutOfMemoryError, NoClassDefFoundError, ...)
10. **Lưu ý**
- Không dùng return trong khối finally (điều này làm mất exception được ném)
- Không để catch rỗng hoặc chỉ prinStackTrace()
- Không dùng throw trong finally (sẽ bị ghi đè exception ban đầu)
- Không dùng exception như goto