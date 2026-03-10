package synchronize_asynchronize;

public class SyncDemo {
    public static void main(String[] args) {
        System.out.println("--- BẮT ĐẦU XỬ LÝ ĐƠN HÀNG ---");
        long startTime = System.currentTimeMillis();

        // Luồng chính phải tự làm mọi việc và chờ đợi
        luuDatabase();      // Giả sử mất 2 giây
        guiEmailXacNhan();  // Giả sử mất 3 giây

        long endTime = System.currentTimeMillis();
        System.out.println("--- HOÀN THÀNH TẤT CẢ trong: " + (endTime - startTime) + "ms ---");
    }

    public static void luuDatabase() {
        System.out.println("[Sync] Đang lưu thông tin vào Database...");
        sleep(2000); // Giả lập thời gian chạy 2 giây
        System.out.println("[Sync] Lưu Database thành công!");
    }

    public static void guiEmailXacNhan() {
        System.out.println("[Sync] Đang gửi Email cho khách hàng...");
        sleep(3000); // Giả lập thời gian chạy 3 giây
        System.out.println("[Sync] Gửi Email thành công!");
    }

    // Hàm tiện ích để giả lập độ trễ
    private static void sleep(int milliseconds) {
        try { Thread.sleep(milliseconds); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}