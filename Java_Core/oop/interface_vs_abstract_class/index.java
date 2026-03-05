package oop.interface_vs_abstract_class;

abstract class HinhHoc {
    protected String mau;
    public HinhHoc(String mau) {
        this.mau = mau;
    }
    public abstract double dienTich();
}

class HinhTron extends HinhHoc {
    private double banKinh;
    public HinhTron (String mau, double banKinh) {
        super(mau);
        this.banKinh = banKinh;
    }
    @Override
    public double dienTich() {
        return this.banKinh*this.banKinh*3.14;
    }
}

class HinhVuong extends HinhHoc {
    private double canh;
    public HinhVuong (String mau, double canh) {
        super(mau);
        this.canh = canh;
    }
    @Override
    public double dienTich() {
        return this.canh*this.canh;
    }
}

//public class index {
//    public static void main(String[] args) {
//        HinhHoc a = new HinhVuong("xanh", 2);
//        HinhHoc b = new HinhTron("do", 2);
//        System.out.println(a.dienTich());
//        System.out.println(b.dienTich());
//    }
//}

interface DongVat {
    void anUong();
}

interface ThuCung {
    void choiDoChoi();
}

class Cho implements DongVat, ThuCung {
    private String ten;
    public Cho (String ten) {
        this.ten = ten;
    }
    @Override
    public void anUong() {
        System.out.println(ten + " an com");
    }
    @Override
    public void choiDoChoi() {
        System.out.println(ten + " choi bong");
    }
}

public class index {
    public static void main(String[] args) {
        Cho cun = new Cho("Mike");
        cun.anUong();
        cun.choiDoChoi();
    }
}