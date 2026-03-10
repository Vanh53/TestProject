package handle_exception;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class index {


    public static void main(String[] args) {
        try {
            docFile();
        } catch (CustomException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
    public static void docFile() throws CustomException {
        int a = 1;
        if (a == 1) {
            throw new CustomException("Custom exception test!");
        }
    }

}