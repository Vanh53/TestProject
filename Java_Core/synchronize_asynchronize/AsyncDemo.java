package synchronize_asynchronize;

import java.util.concurrent.CompletableFuture;

public class AsyncDemo {
    public static void main(String[] args) {
        System.out.println("--- BẮT ĐẦU CHẠY SONG SONG ---");
        long startTime = System.currentTimeMillis();

        // 1. Giao việc Lưu DB cho thợ số 1 (Mất 2 giây)
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Bắt đầu lưu DB...");
            sleep(2000);
            System.out.println("[" + Thread.currentThread().getName() + "] Lưu DB Xong!");
        });

        // 2. Giao việc Gửi Mail cho thợ số 2 CÙNG LÚC (Mất 3 giây)
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Bắt đầu gửi Email...");
            sleep(3000);
            System.out.println("[" + Thread.currentThread().getName() + "] Gửi Email Xong!");
        });

        // 3. Gom 2 tác vụ lại và yêu cầu Luồng Chính đứng ĐỢI cả 2 làm xong
        System.out.println("[Main] Đang chờ cả 2 thợ làm xong...");
        CompletableFuture.allOf(task1, task2).join(); // Lệnh join() khóa luồng chính lại cho đến khi task1 và task2 đều xong

        // 4. Tác vụ thứ 3 chạy sau khi 2 cái trên đã hoàn thành
        System.out.println("[Main] Cả 2 đã xong. Bắt đầu tác vụ thứ 3: Cập nhật thống kê...");

        long endTime = System.currentTimeMillis();
        System.out.println("--- TỔNG THỜI GIAN CHẠY: " + (endTime - startTime) + "ms ---");
    }

    private static void sleep(int milliseconds) {
        try { Thread.sleep(milliseconds); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}