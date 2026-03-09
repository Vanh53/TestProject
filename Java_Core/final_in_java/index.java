package final_in_java;

final class DongVat {
    protected String ten;
    public DongVat (String ten) {
        this.ten = ten;
    }
    public void nhayNhot () {
        System.out.println(ten + " nhay nhot!");
    }
}

//class Cho extends DongVat {
//    public Cho (String ten) {
//        super(ten);
//    }
//    @Override
//    public void nhayNhot() {
//        System.out.println(ten + " nhay day!");
//    }
//}

final class Meo {
    private String mau;
    public Meo(String mau) {
        this.mau = mau;
    }
    public String getMau() {
        return mau;
    }
    public void setMau(String mau) {
        this.mau = mau;
    }
}

public class index {
    public static void main(String[] args) {
        final Meo meo = new Meo("den");
        meo.setMau("trang");
        System.out.println("Mau long meo: " + meo.getMau());
    }
}