package Java.Programacion3.practico6.aritmetico;

public class TestArbolAritmetico {
    public static void main(String[] args) {
        try {
            ArbolAritmetico b1 = new ArbolAritmetico("1+2*3");
            //
            System.out.println(b1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
