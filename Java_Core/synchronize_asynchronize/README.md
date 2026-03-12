# Đồng bộ và bất đồng bộ
## 1. Phương thức đồng bộ - Synchronized Methods
- Thêm từ khóa synchronized vào trước kiểu trả về để định nghĩa phương thức đồng bộ
- Làm cho nhiều luồng cùng gọi phương thức này sẽ không thể chạy đồng thời -> thực thi một cách tuần tự
- Ví dụ:
```java
// Khi không synchronized
public static void main(String[] args) {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for(int i = 1; i <= 3; i++)
            System.out.println(Thread.currentThread().getName() + " task " + i);
        }
    };

    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);

    thread1.setName("Thread 1");
    thread2.setName("Thread 2");
    thread1.start();
    thread2.start();
}
```
-> Kết quả chạy không tuần tự:
```java
Thread 2 task 1
Thread 2 task 2
Thread 1 task 1
Thread 2 task 3
Thread 1 task 2
Thread 1 task 3
```
```java
// Khi có synchronized
Runnable runnable = new Runnable() {
    @Override
    public synchronized void run() {
        for(int i = 1; i <= 3; i++)
        System.out.println(Thread.currentThread().getName() + " task " + i);
    }
};
```
-> Kết quả: chạy đồng bộ tuần tự
```java
Thread 1 task 1
Thread 1 task 2
Thread 1 task 3
Thread 2 task 1
Thread 2 task 2
Thread 2 task 3
```
## 2. Khối đồng bộ - Synchronized Blocks
- Đồng bộ toàn bộ phương thức làm cho các luồng không thực hiện được song song (ảnh hưởng tính đa luồng) -> sử dụng khối 
đồng bộ
- Khối đồng bộ chỉ khóa một đoạn code nhất định (synchronized (this) { ... }), -> tối ưu hóa hiệu suất mà vẫn bảo vệ được 
luồng dữ liệu quan trọng
- Ví dụ:
```java
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        synchronized (this) {
            for(int i = 1; i <= 3; i++) System.out.println(Thread.currentThread().getName() + " task " + i);
        }
    }
};
```
## 3. Hàm callbacks đồng bộ và bất đồng bộ trong java - Asynchronous and Synchronous Callbacks in Java
- Callback là một hàm được truyền vào một hàm khác dưới dạng đối số và dự kiến được thực thi 
- Mục đích: thông báo cho một lớp biết rằng công việc ở một lớp khác đã được hoàn thành
- Được triển khai bằng cách định nghĩa một interface, triển khai nó ở một lớp, đăng ký tham chiếu ở lớp 
khác và dùng tham chiếu đó để gọi phương thức.
### 3.1 Hàm callbacks đồng bộ - Synchronous Callback
- Chương trình chạy tuần tự
- Nhược điểm: callback hoàn thành mọi công việc trước khi trả về câu lệnh gọi, khiến chương trình có vẻ như bị lag
- Sử dụng cho các quy trình có nhiều tác vụ phải thực hiện theo trình tự và không chiếm nhiều thời gian 
(ví dụ: xếp hàng mua vé)
- Ví dụ:
```java
interface CalculatorListener {
    int TongN(int n);
}

class Calculator implements  CalculatorListener {
    @Override
    public int TongN(int n) {
        int sum = 0;
        for(int i = 0; i <= n; i++) sum += i;
        return sum;
    }
}

class NhanVienAsync {
    public void lamViec(CalculatorListener listener, int n) {
        System.out.println("[Nhân viên] Bắt đầu làm việc!!");
        System.out.println("[Nhân viên] Bắt đầu tính tổng!!");
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {}
        System.out.println("Tổng cần tính: " + listener.TongN(n));
        System.out.println("[Nhân viên] Tính tổng xong!!");
    }
}

public class SyncCallbackDemo {
    public static void main(String[] args) {
        System.out.println("[Sếp] Giao việc cho nhân viên ...");

        // Khởi tạo nhân viên
        NhanVienAsync nhanVien = new NhanVienAsync();

        Calculator calculator = new Calculator();
        nhanVien.lamViec(calculator, 5);

        System.out.println("[Sếp] Đi uống cà phê sau khi có kết quả!!");

    }
}
```
-> Kết quả:
```java
[Sếp] Giao việc cho nhân viên ...
[Nhân viên] Bắt đầu làm việc!!
[Nhân viên] Bắt đầu tính tổng!!
Tổng cần tính: 15
[Nhân viên] Tính tổng xong!!
[Sếp] Đi uống cà phê sau khi có kết quả!!
```
### 3.2 Hàm callbacks bất đồng bộ - Asynchronous Callback
- Chương trình thực hiện song song các luồng
- Để thực hiện bất đồng bộ, cần tạo một luồng mới và gọi phương thức callback bên trong luồng đó
- Sử dụng khi các tác vụ không phụ thuộc vào nhau và có thể mất nhiều thời gian để thực thi (ví dụ: tải file từ 
internet, gọi API, đặt đồ ăn trong nhà hàng)
- Ví dụ:
```java
interface CalculatorListener {
    int TongN(int n);
}

class Calculator implements  CalculatorListener {
    @Override
    public int TongN(int n) {
        int sum = 0;
        for(int i = 0; i <= n; i++) sum += i;
        return sum;
    }
}

class NhanVienAsync {
    public void lamViec(CalculatorListener listener, int n) {
        System.out.println("[Nhân viên] Bắt đầu làm việc!!");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("[Nhân viên] Bắt đầu tính tổng!!");
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {}
                System.out.println("Tổng cần tính: " + listener.TongN(n));
                System.out.println("[Nhân viên] Tính tổng xong!!");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}

public class AsyncCallbackDemo {
    public static void main(String[] args) {
        System.out.println("[Sếp] Giao việc cho nhân viên ...");

        // Khởi tạo nhân viên
        NhanVienAsync nhanVien = new NhanVienAsync();
        
        Calculator calculator = new Calculator();
        nhanVien.lamViec(calculator, 5);

        System.out.println("[Sếp] Đi uống cà phê luôn!!");

        // Giữ cho chương trình (Sếp) sống đủ lâu để kịp nhận tin nhắn của nhân viên
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
    }
}
```
-> Kết quả:
```java
[Sếp] Giao việc cho nhân viên ...
[Nhân viên] Bắt đầu làm việc!!
[Sếp] Đi uống cà phê luôn!!
[Nhân viên] Bắt đầu tính tổng!!
Tổng cần tính: 15
[Nhân viên] Tính tổng xong!!
```