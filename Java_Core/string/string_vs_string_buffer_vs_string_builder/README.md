1. String là lớp bất biến (inmutable), còn StringBuilder và StringBuffer là lớp có thể thay đổi (Mutable)
2. String là bất biến 
-> Khi thực hiện cắt, nối chuỗi thì sẽ tạo ra hoặc trả về chuỗi mới

Ví dụ:

    ```java
    public static void main(String[] args) {
        String s = "Vanh";
        String res = daoNguoc(s);
        System.out.println(res);
        String sub = s.substring(0,2);
        System.out.println(sub);
        System.out.println(s);
    }
    public static String daoNguoc (String s) {
        String res = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i);
        }
        return res;
    }    
    ```

-> Kết quả: 

    ```java
    hnaV
    Va
    Vanh
    ```

-> Giải thích: s sao khi thực hiện các hàm substring() hay daoNguoc() sẽ không bị thay đổi giá trị, mà chỉ trả về chuỗi mới

3. StringBuffer có tính đồng bộ hóa và an toàn cho đa luồng, còn StringBuilder thì không
-> StringBuilder sẽ có tốc độ nhanh hơn, và cả 2 đều có thể thay đổi giá trị

Ví dụ với StringBuilder:

    ```java
    System.out.println("----");
    StringBuilder sb = new StringBuilder("Hoang");
    System.out.println(sb.toString());
    sb.append(" Anh");
    System.out.println(sb.toString());
    ```

-> Kết quả: 

    ```java
    Hoang
    Hoang Anh
    ```