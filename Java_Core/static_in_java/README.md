## Static in java
1. **The Static fields**
- Biến tĩnh là biến thuộc về một lớp (chứ không phải của riêng đối tượng nào) và có thể truy cập trực tiếp thông 
qua bên lớp
- Có thể truy cập mà không cần khởi tạo đối tượng, dùng chung cho tất cả đối tượng thuộc lớp đó
- Chỉ khởi tạo một lần duy nhất khi nạp class vào bộ nhớ
- Ví dụ:
```java
class Student {
    private String msv;
    private  String name;
    public static int numberOfStudents;
}

public class index {
    public static void main(String[] args) {
        Student.numberOfStudents = 2;
        System.out.println("Số student là: " + Student.numberOfStudents);
    }
}
```
-> Kết quả:
```java
Số student là: 2
```
2. **The static methods**
- Tương tự như biến static, phương thức static cũng thuộc về một class và dùng chung cho tất cả đối tượng thuộc class đó, 
truy cập thông qua tên class

Ví dụ:

```java
class Student {
    private String msv;
    private  String name;
    public static int numberOfStudents;
    public static void sound() {
        System.out.println("Số lượng học sinh: " + numberOfStudents);
    }
}

public class index {
    public static void main(String[] args) {
        Student.numberOfStudents = 2;
        Student.sound();
    }
}
```
-> Kết quả:
```java
Số lượng học sinh: 2
```
- Không thể sử dụng từ khóa this hoặc super bên trong phương thức static

Ví dụ:

```java
class Student {
    private String msv;
    private  String name;
    public static int numberOfStudents;
    public static void sound() {
        System.out.println("Student's name: " + this.name);
    }
}
```
-> Giải thích: phương thức sound() là static nên sẽ được tạo lúc biên dịch, lúc này chưa có đối tượng nào của class, 
nên this.name lúc này chưa tồn tại
3. **A static block**
- Là đoạn khối mã sử dụng từ khóa static và bọc trong {}
- Dùng để khởi tạo giá trị cho các biến tĩnh
- Chạy một lần duy nhất, chạy trước hàm main (nếu trong cùng một class) và constructor, thực thi theo thứ tự viết code nếu có nhiều khối
- Ví dụ:
```java
class StaticBlock {
    private String name;
    private static int number;
    public StaticBlock(String name) {
        this.name = name;
        System.out.println("Hàm Constructor chạy!");
    }
    static {
        number = 10;
        System.out.println("Khởi tạo biến static");
    }

}

public class index {
    public static void main(String[] args) {
        System.out.println("Hàm main chạy trước khi khởi tạo block");
        StaticBlock staticBlock = new StaticBlock("Block 1");
        System.out.println("Hàm main sau khi khởi tạo block");
    }
}
```
-> Kết quả:
```java
Hàm main chạy trước khi khởi tạo block
Khởi tạo biến static
Hàm Constructor chạy!
Hàm main sau khi khởi tạo block
```
4. **A static class**
- Lớp lồng tĩnh (Static Nested Class)
    - Lớp con nằm trực tiếp trong lớp cha
    - Sử dụng từ khóa static
    - Lớp con chỉ có thể truy cập đến các thuộc tính và phương thức static của lớp cha
    - Ví dụ:
```java
class Parent {
    private int id;
    public Parent(int id) {
        this.id = id;
    }
    public static class Chill {
        private String name;
        public Chill(String name) {
            this.name = name;
        }
        public void sound () {
            System.out.println("This is: " + this.name);
        }
    }
}

public class index {
    public static void main(String[] args) {
        Parent.Chill chill = new Parent. Chill("CHill 1");
        chill.sound();
    }
}
```
-> Kết quả:
```java
This is: CHill 1
```
- Lớp nội (Inner Class / Non-static Nested Class)
    - Lớp con nằm trực tiếp trong lớp cha
    - Không cần từ khóa static
    - Lớp con có thể truy cập đến các trường private của lớp cha
    - Bắt buộc phải khởi tạo lớp cha trước rồi mới tới lớp con (lớp con luôn phải đi liền với lớp cha)
    - Ví dụ:
```java
class DuAn {
    private String tenDuAn;
    public DuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }
    class NhiemVu {
        private String tenNhiemVu;
        public NhiemVu(String tenNhiemVu) {
            this.tenNhiemVu = tenNhiemVu;
        }
        public void sound() {
            System.out.println("Nhiem vu: " + this.tenNhiemVu + ", thuoc du an: " + tenDuAn);
        }
    }
}

public class index {
    public static void main(String[] args) {
        DuAn duAn = new DuAn("Du an 1");
        DuAn.NhiemVu nhiemVu = duAn. new NhiemVu("Nhiem vu 1");
        nhiemVu.sound();
    }
}
```
-> Kết quả:
```java
Nhiem vu: Nhiem vu 1, thuoc du an: Du an 1
```
