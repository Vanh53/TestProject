## Final trong java
1. **Final variable**
- Biến được khai báo là final sẽ chỉ được gán giá trị một lần duy nhất, không thể thay đổi sau khi gán

Ví dụ:

```java
public static void main(String[] args) {
    final int a = 1;
    a = 2;
}
```
-> Lỗi: 
```java
java: cannot assign a value to final variable a
```
- Tham số final sẽ không thể bị thay đổi bên trong phương thức

Ví dụ:

```java
public static void finalArgument(final int a) {
    a = 2;
}
```
-> Lỗi: 
```java
java: final parameter a may not be assigned
```
- Nếu biến final là một Object, thì không thể gán cho đối tượng khác những vẫn có thể thay đổi nội dung của đối tượng đó

Ví dụ:

```java
final class Meo {
    private String mau;
    public Meo(String mau) {
        this.mau = mau;
    }
    public String getMau() {
        return mau;
    }
    public void setMau(String mau) {
        this.mau = mau;
    }
}

public class index {
    public static void main(String[] args) {
        final Meo meo = new Meo("den");
        meo.setMau("trang");
        System.out.println("Mau long meo: " + meo.getMau());
    }
}
```
-> Kết quả:
```java
Mau long meo: trang
```
- Dùng kết hợp static để tạo hằng số:

Ví dụ:

```java
public static final double PI = 3.14;
```
2. **Final Method**
- Các phương thức được đánh dấu là final không thể bị ghi đè.
- Ví dụ:
```java
class DongVat {
    protected String ten;
    public DongVat (String ten) {
        this.ten = ten;
    }
    public final void nhayNhot () {
        System.out.println(ten + " nhay nhot!");
    }
}
```
-> Lớp con không thể ghi đè nhayNhot()

3. **Final Class**
- Một lớp được khai báo là final thì lớp khác sẽ không thể kế thừa được nó, các phương thức bên trong lớp final cũng mặc định là final
- Ví dụ:
```java
final class DongVat {
    protected String ten;
    public DongVat (String ten) {
        this.ten = ten;
    }
    public void nhayNhot () {
        System.out.println(ten + " nhay nhot!");
    }
}
```
-> Các lớp khác sẽ không thể extends DongVat