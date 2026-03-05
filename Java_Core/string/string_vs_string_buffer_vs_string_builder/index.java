package string.string_vs_string_buffer_vs_string_builder;
import java.util.GregorianCalendar;

public class index {
    public static void main(String[] args) {
        String s = "Vanh";

        String res = daoNguoc(s);
        System.out.println(res);

    }

    public static String daoNguoc (String s) {
        String res = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i);
        }
        return res;
    }



}