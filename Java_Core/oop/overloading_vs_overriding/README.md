# Tính đa hình
*Một phương thức có thể có nhiều hình thái khác nhau*
1. Overloading (Nạp chồng)
- Đa hình tại thời điểm biên dịch
- Xảy ra trong cùng một class
- Nhiều phương thức có cùng tên những khác nhau danh sách tham số (kiểu dữ liệu trả về có thể giống hoặc khác)
- Ví dụ:
```java
class PhepTinh {
    public static double PhepCong (double a, double b) {
        return a + b;
    }
    public static double PhepCong (double a, double b, double c) {
        return a + b + c;
    }
}

public class index {
    public static void main(String[] args) {
        System.out.println(PhepTinh.PhepCong(1,2));
        System.out.println(PhepTinh.PhepCong(1, 2, 3));
    }
}
```
-> Kết quả:
```java
3.0
6.0
```
2. Overriding (Ghi đè)
- Đa hình tại thời điểm thực thi
- Xảy ra giữa lớp cha và lớp con
- Lớp con có thể ghi đè phương thức của lớp cha (kiểu dữ liệu trả về và danh sách tham số phải giống hệt)
- Ví dụ:
```java
abstract class DongVat {
    protected String ten;
    public DongVat (String ten) {
        this.ten = ten;
    }
    public abstract void keu();
}

class Meo extends DongVat{
    public Meo (String ten) {
        super(ten);
    }
    @Override
    public void keu() {
        System.out.println("Meo keu meo meo");
    }
}

public class index {
    public static void main(String[] args) {
        DongVat dv = new Meo("MIke");
        dv.keu();
    }
}
```
-> Kết quả:
```java
Meo keu meo meo
```