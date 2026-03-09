package static_in_java;

class Student {
    private String msv;
    private  String name;
    public static int numberOfStudents;
    public static void sound() {
        System.out.println("Số lượng học sinh: " + numberOfStudents);
    }
}

class DuAn {
    private String tenDuAn;
    public DuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }
    class NhiemVu {
        private String tenNhiemVu;
        public NhiemVu(String tenNhiemVu) {
            this.tenNhiemVu = tenNhiemVu;
        }
        public void sound() {
            System.out.println("Nhiem vu: " + this.tenNhiemVu + ", thuoc du an: " + tenDuAn);
        }
    }
}

class Parent {
    private int id;
    public Parent(int id) {
        this.id = id;
    }
    public static class Chill {
        private String name;
        public Chill(String name) {
            this.name = name;
        }
        public void sound () {
            System.out.println("This is: " + this.name);
        }
    }
}

class StaticBlock {
    private String name;
    private static int number;
    public StaticBlock(String name) {
        this.name = name;
        System.out.println("Hàm Constructor chạy!");
    }
    static {
        number = 10;
        System.out.println("Khởi tạo biến static");
    }

}

public class index {
    public static void main(String[] args) {
        System.out.println("Hàm main chạy trước khi khởi tạo block");
        StaticBlock staticBlock = new StaticBlock("Block 1");
        System.out.println("Hàm main sau khi khởi tạo block");
    }
}

//public class index {
//    public static void main(String[] args) {
//        DuAn duAn = new DuAn("Du an 1");
//        DuAn.NhiemVu nhiemVu = duAn. new NhiemVu("Nhiem vu 1");
//        nhiemVu.sound();
//    }
//}