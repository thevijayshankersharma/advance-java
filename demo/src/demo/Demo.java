package demo;

public class Demo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("hello");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
