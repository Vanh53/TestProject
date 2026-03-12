package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class index {
    public static void main(String[] args) {
//        long startTime1 = System.currentTimeMillis();
//        ArrayList<Integer> arr = new ArrayList<>();
//        for(int i = 0; i < 1000000; i++) arr.addFirst(i);
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("Thời gian add 1tr phần tử vào đầu ArrayList: " + (endTime1 - startTime1) + "ms");
//
//        long startTime2 = System.currentTimeMillis();
//        for(int i = 0; i < 1000000; i++) arr.get(i);
//        long endTime2 = System.currentTimeMillis();
//        System.out.println("Thời gian truy xuất 1tr phần tử trong ArrayList: " + (endTime2 - startTime2) + "ms");

        long startTime1 = System.currentTimeMillis();
        LinkedList<Integer> arr = new LinkedList<>();
        for(int i = 0; i < 1000000; i++) arr.addFirst(i);
        long endTime1 = System.currentTimeMillis();
        System.out.println("Thời gian add 1tr phần tử vào đầu LinkedList: " + (endTime1 - startTime1) + "ms");

        long startTime2 = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) arr.get(i);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Thời gian truy xuất 1tr phần tử trong LinkedList: " + (endTime2 - startTime2) + "ms");
    }
}