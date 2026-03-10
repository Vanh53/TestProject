package handle_exception;

public class index {
    public static void main(String[] args) {
        kiemTraTuoi(-1);
    }
    public static void kiemTraTuoi(int tuoi) {
        if (tuoi < 0) {
            // Chủ động ném ra một lỗi
            throw new IllegalArgumentException("Tuổi không được là số âm!");
        }
        System.out.println("Tuổi hợp lệ: " + tuoi);
    }
}