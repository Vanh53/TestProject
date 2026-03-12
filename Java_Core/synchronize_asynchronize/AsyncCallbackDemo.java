package synchronize_asynchronize;

//interface CalculatorListener {
//    int TongN(int n);
//}
//
//class Calculator implements  CalculatorListener {
//    @Override
//    public int TongN(int n) {
//        int sum = 0;
//        for(int i = 0; i <= n; i++) sum += i;
//        return sum;
//    }
//}
//
//class NhanVienAsync {
//    public void lamViec(CalculatorListener listener, int n) {
//        System.out.println("[Nhân viên] Bắt đầu làm việc!!");
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("[Nhân viên] Bắt đầu tính tổng!!");
//                try {
//                    Thread.sleep(3000);
//                }
//                catch (InterruptedException e) {}
//                System.out.println("Tổng cần tính: " + listener.TongN(n));
//                System.out.println("[Nhân viên] Tính tổng xong!!");
//            }
//        };
//
//        Thread thread = new Thread(runnable);
//        thread.start();
//    }
//}
//
//public class AsyncCallbackDemo {
//    public static void main(String[] args) {
//        System.out.println("[Sếp] Giao việc cho nhân viên ...");
//
//        // Khởi tạo nhân viên
//        NhanVienAsync nhanVien = new NhanVienAsync();
//
//        Calculator calculator = new Calculator();
//        nhanVien.lamViec(calculator, 5);
//
//        System.out.println("[Sếp] Đi uống cà phê luôn!!");
//
//        // Giữ cho chương trình (Sếp) sống đủ lâu để kịp nhận tin nhắn của nhân viên
//        try { Thread.sleep(5000); } catch (InterruptedException e) {}
//    }
//}