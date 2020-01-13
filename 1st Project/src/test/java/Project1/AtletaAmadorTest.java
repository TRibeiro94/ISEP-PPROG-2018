package Project1;

import Project1.AtletaAmador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 * @author Pedro Água (1180809)
 */
public class AtletaAmadorTest {
    
    public AtletaAmadorTest() {
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
     * Teste 1 do método calcularPagamento, da classe AtletaAmador.
     */
    @Test
    public void testCalcularPagamento1() {
        System.out.println("calcularPagamento");
        AtletaAmador instance = new AtletaAmador("Valentino", 654677901, "masculino", 29, "corrida", 34, 100, 5);
        double expResult = 9;
        double result = instance.calcularPagamento();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Teste 2 do método calcularPagamento, da classe AtletaAmador.
     */
    @Test
    public void testCalcularPagamento2() {
        System.out.println("calcularPagamento2");
        AtletaAmador instanciaAmador = new AtletaAmador("Valentino", 654677901, "masculino", 29, "corrida", 34, 50, 6);
        double expResult = 5;
        double result = instanciaAmador.calcularPagamento();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Teste 3 do método calcularPagamento, da classe AtletaAmador.
     */
    @Test
    public void testCalcularPagamento3() {
        System.out.println("calcularPagamento3");
        AtletaAmador instanciaAmador = new AtletaAmador("Valentino", 654677901, "masculino", 29, "corrida", 34, 200, 21);
        double expResult = 54;
        double result = instanciaAmador.calcularPagamento();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Teste 1 do método calcularParcelaVariavel, da classe AtletaAmador.
     */
    @Test
    public void testCalcularParcelaVariavel() {
        System.out.println("calcularParcelaVariavel");
        AtletaAmador instance = new AtletaAmador("Valentino", 654677901, "masculino", 29, "corrida", 34, 1000, 15);
        double expResult = 80;
        double result = instance.calcularParcelaVariavel();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Teste 1 do método calcularParcelaVariavel2, da classe AtletaAmador.
     */
    @Test
    public void testCalcularParcelaVariavel2() {
        System.out.println("calcularParcelaVariavel2");
        AtletaAmador instance = new AtletaAmador("Valentino", 654677901, "masculino", 29, "corrida", 34, 750, 5);
        double expResult = 52.5;
        double result = instance.calcularParcelaVariavel2();
        assertEquals(expResult, result, 0.1);
    }

}
