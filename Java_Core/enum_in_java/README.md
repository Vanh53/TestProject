## Enum trong java

1. Enum
- Là một class đặc biệt, lưu danh sách các đối tượng tĩnh và bất biến
- Kiểu dữ liệu của các đối tượng trong danh sách hằng số chính là tên enum 
2. Một số phương thức tích hợp sẵn
- values(): trả về mảng danh sách hằng số trong enum theo thứ tự gốc
- valuesOf(String): chuyển 1 chuỗi string thành 1 đối tượng enum
- ordinal(): trả về vị trí của hằng số trong enum
- name(): trả về tên hằng số dưới dạng string
- Ví dụ: 
```java
enum Day {
    thuHai, thuBa, thuTu;
}

public class index {
    public static void main(String[] args) {
        for(Day day: Day.values()) {
            System.out.println(day.name() + " nam o vi tri: " + day.ordinal());
        }
        Day day = Day.valueOf("thuBa");
        System.out.println("Vi tri tim duoc la: " + day.ordinal());
    }
}
```
-> Kết quả:
```java
thuHai nam o vi tri: 0
thuBa nam o vi tri: 1
thuTu nam o vi tri: 2
Vi tri tim duoc la: 1
```
3. Enum với thuộc tính, constructor, phương thức
- Enum có thể chứa biến, phương thức và constructor
- Constructor buộc phải là private
- Ví dụ:
```java
enum OrderStatus {
    Pending(100, "Dang xu ly!"),
    Shipping(101, "Dang giao hang!"),
    Delivered(102, "Da giao!");

    private final int id;
    private final String des;

    OrderStatus(int id, String des) {
        this.id = id;
        this.des = des;
    }
    public int getId() {
        return id;
    }
    public String getDes() {
        return des;
    }
}

public class index {
    public static void main(String[] args) {
        for(OrderStatus orderStatus: OrderStatus.values()) {
            System.out.println("Don hang " + orderStatus.getId() + " " + orderStatus.getDes() +  " - " + orderStatus.name());
        }
    }
}
```
-> Kết quả:
```java
Don hang 100 Dang xu ly! - Pending
Don hang 101 Dang giao hang! - Shipping
Don hang 102 Da giao! - Delivered
```
4. Đa hình trong enum
- Thực hiện bằng cách khai báo một phương thức abstract trong enum và ghi đè
- Ví dụ:
```java
enum Calculator {
    Cong {
        @Override
        public double calculator(double a, double b) {
            return a + b;
        }
    },
    Tru {
        @Override
        public double calculator(double a, double b) {
            return a - b;
        }
    };
    public abstract double calculator(double a, double b);
}

public class index {
    public static void main(String[] args) {
        System.out.println(Calculator.Cong.calculator(10, 5));
        System.out.println(Calculator.Tru.calculator(10, 5));
    }
}
```
-> Kết quả:
```java
15.0
5.0
```