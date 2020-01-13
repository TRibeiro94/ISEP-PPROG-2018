package Utils;

import org.junit.Test;
import static org.junit.Assert.*;

/** 
 * @author Tiago Ribeiro (1181444)
 */
public class UtilitariosTest {
    
    public UtilitariosTest() {
    }

    /**
     * Teste do método isNumeric da classe Utilitarios.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("is Numeric");
        String string = "4";
        boolean expResult = true;
        
        boolean result = Utilitarios.isNumeric(string);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método calculoDoCusto da classe Utilitarios.
     */
    @Test
    public void testCalculoDoCusto() {
        System.out.println("calculo Do Custo");
        int hora1 = 13;
        int hora2 = 20;
        double custoServico = 51.25;
        double expResult = 358.75;
        double result = Utilitarios.calculoDoCusto(hora1, hora2, custoServico);
        assertEquals(expResult, result, 0.0);
    }
    
}
