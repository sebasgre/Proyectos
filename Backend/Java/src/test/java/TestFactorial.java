import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import Programacion4.Pruebas.Factorial;

public class TestFactorial {
    @Test
    public void testFactorial0() {
        Factorial objFactorial = new Factorial();
        BigInteger actual = objFactorial.calcularFactorial(0);
        BigInteger expected = new BigInteger("1");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFactorial5() {
        Factorial objFactorial = new Factorial();
        BigInteger actual = objFactorial.calcularFactorial(5);
        BigInteger expected = new BigInteger("120");


        Assert.assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialParaNegativo() {

        Factorial objFactorial = new Factorial();
        BigInteger actual = objFactorial.calcularFactorial(-5);

    }

    @Test
    public void testFactorial100() {

        Factorial objFactorial = new Factorial();
        BigInteger actual = objFactorial.calcularFactorial(100);
        BigInteger expected = new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");

        Assert.assertEquals(expected, actual);
    }
}
