import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ContParametrizedTest {

    private String titular;
    private String iban;
    private double balanta;
    private double dobanda;
    private double suma;
    private double expectedWithdraw;
    private double expectedDeposit;
    private double expectedDobanda;
    private String expecteString;

    public ContParametrizedTest(String titular, String iban, double balanta,
                                double dobanda, double suma, double expectedWithdraw,
                                double expectedDeposit, double expectedDobanda, String expecteString) {
        this.titular = titular;
        this.iban = iban;
        this.balanta = balanta;
        this.dobanda = dobanda;
        this.suma = suma;
        this.expectedWithdraw = expectedWithdraw;
        this.expectedDeposit = expectedDeposit;
        this.expectedDobanda = expectedDobanda;
        this.expecteString = expecteString;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Mihai", "1231_1234_1234_1444",
                    1000.0, 0.01, 100.0, 900.0, 1100.0, 1010.0,
                    "Mihai are in contul bancar 1231_1234_1234_1444 1000.0 lei."},
            {"Matei", "1111_1111_2222_2222",
                    2000.0, 0.02, 200.0, 1800.0, 2200.0, 2040.0,
                    "Matei are in contul bancar 1111_1111_2222_2222 2000.0 lei."}
            }
        );
    }

    @Test
    public void withdrawTest(){
        Cont cont = new Cont(titular, iban, balanta, dobanda);
        double result = cont.withdraw(suma);
        Assert.assertEquals(expectedWithdraw, result, 0.0);
    }

    @Test
    public void depositTest(){
        Cont cont = new Cont(titular, iban, balanta, dobanda);
        double result = cont.deposit(suma);
        Assert.assertEquals(expectedDeposit, result, 0.0);
    }

    @Test
    public void adaugaDobandaTest(){
        Cont cont = new Cont(titular, iban, balanta, dobanda);
        double result = cont.adaugaDobanda();
        Assert.assertEquals(expectedDobanda, result, 0.0);
    }

    @Test
    public void toStringTest(){
        Cont cont = new Cont(titular, iban, balanta, dobanda);
        String result = cont.toString();
        Assert.assertEquals(expecteString, result);
    }
}