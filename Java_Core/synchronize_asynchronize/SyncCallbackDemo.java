package synchronize_asynchronize;

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