## Tính trừu tượng
***Ẩn đi những chi tiết triển khai, chỉ hiển thị phần khung***

***Lớp con phải triển khai tất cả phương thức trừu tượng của lớp cha***
1. Abstract class: 
- Quan hệ IS-A, ví dụ: Hình tròn là một Hình học
- Là một class, dùng từ khóa extends
- Một lớp chỉ có thể extends một Abstract class
- Có Constructor, biến có thể là private, protected hoặc public
- Lớp cha có thể chứa cả phương thức trừu tượng hoặc phương thức thông thường
- Chỉ lớp trừu tượng mới có phương thức trừu tượng
- Ví dụ:
```java
abstract class HinhHoc {
    protected String mau;
    public HinhHoc(String mau) {
        this.mau = mau;
    }
    public abstract double dienTich();
}

class HinhTron extends HinhHoc {
    private double banKinh;
    public HinhTron (String mau, double banKinh) {
        super(mau);
        this.banKinh = banKinh;
    }
    @Override
    public double dienTich() {
        return this.banKinh*this.banKinh*3.14;
    }
}

class HinhVuong extends HinhHoc {
    private double canh;
    public HinhVuong (String mau, double canh) {
        super(mau);
        this.canh = canh;
    }
    @Override
    public double dienTich() {
        return this.canh*this.canh;
    }
}

public class index {
    public static void main(String[] args) {
        HinhHoc a = new HinhVuong("xanh", 2);
        HinhHoc b = new HinhTron("do", 2);
        System.out.println(a.dienTich());
        System.out.println(b.dienTich());
    }
}
```
-> Kết quả:
```java
4.0
12.56
```
2. Interface:
- Quan hệ CAN-DO, ví dụ: Chim có thể Bay, Chó có thê Chạy
- Dùng từ khóa emplements
- Một lớp có thể Implements nhiều Interfaces (đa kế thừa)
- Không có constructor, biến chỉ có thể public static final
- Lớp cha chỉ có phương thức trừu tượng
- Tính trừu tượng cao hơn Abstract
- Ví dụ:
```java
interface DongVat {
    void anUong();
}

interface ThuCung {
    void choiDoChoi();
}

class Cho implements DongVat, ThuCung {
    private String ten;
    public Cho (String ten) {
        this.ten = ten;
    }
    @Override
    public void anUong() {
        System.out.println(ten + " an com");
    }
    @Override
    public void choiDoChoi() {
        System.out.println(ten + " choi bong");
    }
}

public class index {
    public static void main(String[] args) {
        Cho cun = new Cho("Mike");
        cun.anUong();
        cun.choiDoChoi();
    }
}
```
-> Kết quả: 
```java
Mike an com
Mike choi bong
```