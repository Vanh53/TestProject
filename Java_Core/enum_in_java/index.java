package enum_in_java;
enum Day {
    thuHai, thuBa, thuTu;
}

enum Calculator {
    Cong {
        @Override
        public double calculator(double a, double b) {
            return a + b;
        }
    },
    Tru {
        @Override
        public double calculator(double a, double b) {
            return a - b;
        }
    };
    public abstract double calculator(double a, double b);
}

enum OrderStatus {
    Pending(100, "Dang xu ly!"),
    Shipping(101, "Dang giao hang!"),
    Delivered(102, "Da giao!");

    private final int id;
    private final String des;

    OrderStatus(int id, String des) {
        this.id = id;
        this.des = des;
    }
    public int getId() {
        return id;
    }
    public String getDes() {
        return des;
    }
}

public class index {
    public static void main(String[] args) {
        for(OrderStatus orderStatus: OrderStatus.values()) {
            System.out.println("Don hang " + orderStatus.getId() + " " + orderStatus.getDes() +  " - " + orderStatus.name());
        }
    }
}