package passing_in_java;

//public class index {
//    public static void main(String[] args) {
//        int a = 20;
//        System.out.println("Gia tri luc truoc: " + a);
//        passingByValue(a);
//        System.out.println("Gia tri luc sau: " + a);
//    }
//    public static void passingByValue(int a) {
//        a = 30;
//        System.out.println("Gia tri trong ham: " + a);
//    }
//}

public class index {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) arr[i] = i;
        System.out.print("Gia tri luc truoc:" );
        for(int i = 0; i < 5; i++) System.out.print(arr[i] + " ");
        System.out.println("");
        passingByReference(arr);
        System.out.print("Gia tri luc sau: ");
        for(int i = 0; i < 5; i++) System.out.print(arr[i] + " ");
    }
    public static void passingByReference(int[] arr) {
        for(int i = 0; i < 5; i++) arr[i] = 5 - i;
    }
}