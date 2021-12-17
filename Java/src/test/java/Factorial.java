import java.math.BigInteger;

public class Factorial {
    public static BigInteger calcularFactorial(int n){
        if(n < 0)
            throw new IllegalArgumentException("No hay factorial de numeros negativos");

        BigInteger resultado = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(new BigInteger(Integer.toString(i)));
        }
        return resultado;
    }
}
