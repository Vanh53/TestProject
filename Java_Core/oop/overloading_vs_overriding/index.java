package oop.overloading_vs_overriding;

class PhepTinh {
    public static double PhepCong (double a, double b) {
        return a + b;
    }
    public static double PhepCong (double a, double b, double c) {
        return a + b + c;
    }
}

//public class index {
//    public static void main(String[] args) {
//        System.out.println(PhepTinh.PhepCong(1,2));
//        System.out.println(PhepTinh.PhepCong(1, 2, 3));
//    }
//}

abstract class DongVat {
    protected String ten;
    public DongVat (String ten) {
        this.ten = ten;
    }
    public abstract void keu();
}

class Meo extends DongVat{
    public Meo (String ten) {
        super(ten);
    }
    @Override
    public void keu() {
        System.out.println("Meo keu meo meo");
    }
}

public class index {
    public static void main(String[] args) {
        DongVat dv = new Meo("MIke");
        dv.keu();
    }
}