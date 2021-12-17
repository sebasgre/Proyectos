import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class TestCriba {
    private CribaErastotenes criba;

    @Before
    public void setup(){
        criba = new CribaErastotenes(100);
    }

    @Test
    public void esPrimo10(){
        boolean actual = criba.esPrimo(10);

        Assert.assertFalse(actual);
    }

    @Test
    public void esPrimo67(){
        boolean actual = criba.esPrimo(67);

        Assert.assertTrue(actual);
    }

}
