package project2;

import project2.AtletaPro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class AtletaProTest {
    
    public AtletaProTest() {
    }
    @BeforeClass
    public static void setUpClass() {
    }
    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }
    
    /**
     * Teste 1 do método calcularPagamento, da classe AtletaPro.
     * ja subtraido o valor deduzivel em IRS
     */
    @Test
    public void testCalcularPagamento1() {
        System.out.println("calcularPagamento");
        AtletaPro instance = new AtletaPro("Valentino", 654677901, "masculino", 29, "corrida", 34, 800, 80000);
        double expResult = 16720;
        double result = instance.calcularPagamento();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Teste 2 do método calcularPagamento, da classe AtletaPro.
     * ja subtraido o valor deduzivel em IRS
     */
    @Test
    public void testCalcularPagamento2() {
        System.out.println("calcularPagamento");
        AtletaPro instance = new AtletaPro("Valentino", 654677901, "masculino", 29, "corrida", 34, 3000, 1500);
        double expResult = 3000;
        double result = instance.calcularPagamento();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Teste 1 do método calcularParcelaVariavel, da classe AtletaPro.
     */
    @Test
    public void testCalcularParcelaVariavel1() {
        System.out.println("calcularParcelaVariavel");
        AtletaPro instance = new AtletaPro("Valentino", 654677901, "masculino", 29, "corrida", 34, 1000, 5000);
        double expResult = 1000;
        double result = instance.calcularParcelaVariavel();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Teste 2 do método calcularParcelaVariavel, da classe AtletaPro.
     */
    @Test
    public void testCalcularParcelaVariavel() {
        System.out.println("calcularParcelaVariavel");
        AtletaPro instance = new AtletaPro("Valentino", 654677901, "masculino", 29, "corrida", 34, 500, 350000);
        double expResult = 70000;
        double result = instance.calcularParcelaVariavel();
        assertEquals(expResult, result, 0.0);
    }
}
